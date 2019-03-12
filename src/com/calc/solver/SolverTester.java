package com.calc.solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.calc.operations.Add;
import com.calc.operations.Multiply;
import com.calc.operations.Operation;
import com.calc.operations.modifier.AddModifier;
import com.calc.operations.modifier.Modifier;
import com.calc.solver.exception.InvalidResultException;
import com.calc.solver.exception.PuzzleUnsolvedException;

public class SolverTester {

	public static void main(String[] args) {
		Set<Operation> operations = new HashSet<>();
		operations.add(new Add(8));
		operations.add(new Multiply(2));
		operations.add(new Multiply(5));
		operations.add(new AddModifier(1));

		long start = 25;
		int goal = 268;
		int moves = 5;
		Solver s = new Solver(goal, (int) start, moves, operations);

		List<Operation> solution;
		try {
			solution = s.solve();

			for (Operation op : solution) {

				if (op instanceof Modifier) {
					System.out.println(op.toString());

				} else {
					long next = op.apply(start);
					System.out.println(start + " " + op.toString() + " = " + next);
					start = next;
				}

			}
		} catch (PuzzleUnsolvedException | InvalidResultException e) {
			System.out.println("This puzzle remains unsolved!");
		}


	}

}
