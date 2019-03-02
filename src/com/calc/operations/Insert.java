package com.calc.operations;

public class Insert extends Operation {
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

}
