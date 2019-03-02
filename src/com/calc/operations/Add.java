package com.calc.operations;

public class Add extends Operation {
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
}
