package com.calc.operations;

import com.calc.operations.modifier.Modifier;
import com.calc.solver.exception.InvalidResultException;

public class Insert extends Operation implements Modifable<Insert> {
	private int y;

	public Insert(int y) {
		super();
		this.y = y;
	}

	@Override
	public long apply(long x) {
		return x * 10 + y;
	}

	static public void main(String args[]) {
		System.out.println(new Insert(0).apply(293));
	}

	@Override
	public String toString() {
		return "(insert " + y + ")";
	}

	@Override
	public Insert mod(Insert opertion, Modifier mod) throws InvalidResultException {
		return new Insert((int) mod.apply(y));
	}

}
