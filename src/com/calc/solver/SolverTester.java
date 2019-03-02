package com.calc.solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.calc.operations.Add;
import com.calc.operations.Mirror;
import com.calc.operations.Multiply;
import com.calc.operations.Operation;
import com.calc.operations.Reverse;

public class SolverTester {

	public static void main(String[] args) {
		Set<Operation> operations = new HashSet<>();
		operations.add(new Reverse());
		operations.add(new Mirror());
		operations.add(new Add(2));
		operations.add(new Add(8));
		operations.add(new Multiply(3));

		long start = -1;
		int goal = 2020;
		int moves = 8;
		Solver s = new Solver(goal, (int) start, moves, operations);

		List<Operation> solution = s.solve();
		if (solution.isEmpty()) {
			System.out.println("This puzzle remains unsolved!");
		}


		for (Operation op : solution) {
			long next = op.apply(start);
			System.out.println(start + " " + op.toString() + " = " + next);
			start = next;
		}
	}

}
