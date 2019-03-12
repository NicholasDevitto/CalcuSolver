package com.calc.operations.modifier;

import com.calc.solver.exception.InvalidResultException;

public class AddModifier extends Modifier {
	private int y;

	public AddModifier(int y) {
		super();
		this.y = y;
	}

	@Override
	public long apply(long x) throws InvalidResultException {
		int sign = (x < 0) ? -1 : 1;
		long absoluteValue = Math.abs(x);
		return sign * (y + absoluteValue);
	}

}
