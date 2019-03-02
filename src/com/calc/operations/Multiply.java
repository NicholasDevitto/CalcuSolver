package com.calc.operations;

public class Multiply extends Operation {
	private double y;

	public Multiply(double y) {
		super();
		this.y = y;
	}

	@Override
	public long apply(long x) {
		return (long) (x * y);
	}

}
