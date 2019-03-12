package com.calc.solver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.calc.operations.Modifable;
import com.calc.operations.Operation;
import com.calc.operations.modifier.Modifier;
import com.calc.solver.exception.InvalidResultException;
import com.calc.solver.exception.PuzzleUnsolvedException;

public class Solver {
	private long goal;
	private long currentState;
	private int maxDepth;
	private Map<Long, Integer> vistedStates;
	private Stack<Operation> moves;
	private Set<Operation> availableOperations;
	//private Set<Modifier> availableMods;
	private boolean solved = false;

	public Solver(int goal, int currentState, int maxDepth,
			Set<Operation> availableOperations) {
		//, Set<Modifier> availableMods) {
		super();
		this.goal = goal;
		this.currentState = currentState;
		this.maxDepth = maxDepth;
		this.availableOperations = availableOperations;
		//this.availableMods = availableMods;

		init();
	}

	private void init() {
		vistedStates = new HashMap<>();
		moves = new Stack<>();
	}

	private void goDeeper(Set<Operation> availableOperations) {
		if (currentState == goal) {
			solved = true;
			return;
		}

		if (moves.size() >= maxDepth) {
			return;
		}


		if (vistedStates.containsKey(currentState)) {
			if (vistedStates.get(currentState) < moves.size()) {
				return;
			}
		}


		if (String.valueOf(currentState).length() > 6) {
			return;
		}

		for (Operation op : availableOperations) {
			try {
				moves.push(op);

				if (op instanceof Modifier) {
					Set<Operation> moddedOperations = new HashSet<>();
					for (Operation opToMod : availableOperations) {
						if (opToMod instanceof Modifable) {
							moddedOperations.add(((Modifable)opToMod).mod(opToMod, (Modifier) op));
						}else {
							moddedOperations.add(opToMod);
						}
					}
					goDeeper(moddedOperations);
				} else {

					long previousState = currentState;
					vistedStates.put(previousState, moves.size());

					currentState = op.apply(currentState);

					System.out.println("Moves : " + moves);
					System.out.println("Applying " + op);
					System.out.println("Result : " + currentState);
					System.out.println("");

					goDeeper(availableOperations);

					// If we get to here, this state goes nowhere. 
					// Therefore, never visit it again.
					currentState = previousState;
				}

				if (solved) {
					return;
				}

				moves.pop();
			} catch (InvalidResultException e) {
			}

		}

	}

	public List<Operation> solve() throws PuzzleUnsolvedException {
		if (solved) {
			return moves;
		}

		goDeeper(availableOperations);
		if (!solved) {
			throw new PuzzleUnsolvedException();
		}

		return (moves);
	}
}
