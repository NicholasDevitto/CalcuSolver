package com.calc.operations;

import com.calc.operations.modifier.Modifier;
import com.calc.solver.exception.InvalidResultException;

public class Multiply extends Operation implements Modifable<Multiply> {
	private double y;

	public Multiply(double y) {
		super();
		this.y = y;
	}

	@Override
	public long apply(long x) {
		return (long) (x * y);
	}

	@Override
	public String toString() {
		return "*(" + y + ")";
	}

	@Override
	public Multiply mod(Multiply opertion, Modifier mod) throws InvalidResultException {
		return new Multiply(mod.apply((long) y));
	}

}
