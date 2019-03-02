package com.calc.solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.calc.operations.Operation;

public class Solver {
	private long goal;
	private long currentState;
	private int maxDepth;
	private Map<Long, Integer> vistedStates;
	private Stack<Operation> moves;
	private Set<Operation> availableOperations;
	private boolean solved = false;

	public Solver(int goal, int currentState, int maxDepth,
			Set<Operation> availableOperations) {
		super();
		this.goal = goal;
		this.currentState = currentState;
		this.maxDepth = maxDepth;
		this.availableOperations = availableOperations;

		init();
	}

	private void init() {
		vistedStates = new HashMap<>();
		moves = new Stack<>();
	}

	private void goDeeper() {
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
			moves.push(op);

			long previousState = currentState;
			vistedStates.put(previousState, moves.size());

			currentState = op.apply(currentState);
			System.out.println("Moves : " + moves);
			System.out.println("Applying " + op);
			System.out.println("Result : " + currentState);
			System.out.println("");
			goDeeper();

			if (solved) {
				return;
			}

			moves.pop();

			// If we get to here, this state goes nowhere. 
			// Therefore, never visit it again.
			currentState = previousState;
		}
	}

	public List<Operation> solve() {
		if (solved) {
			return moves;
		}

		goDeeper();
		return (moves);
	}
}
