package com.calc.operations;

import com.calc.operations.modifier.Modifier;
import com.calc.solver.exception.InvalidResultException;

public class Add extends Operation implements Modifable<Add> {
	private int y = 0;

	public Add(int y) {
		super();
		this.y = y;
	}

	@Override
	public long apply(long x) {
		return x + y;
	}

	@Override
	public String toString() {
		return "+(" + y + ")";
	}

	@Override
	public Add mod(Add opertion, Modifier mod) throws InvalidResultException {
		return new Add((int) mod.apply(y));
	}
}
