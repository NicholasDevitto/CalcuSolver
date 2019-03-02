package com.calc.operations;

public class ShiftRight extends Operation {

	@Override
	public long apply(long x) {
		double temp = x / 10.0;
		int leftOvers = (int) temp;
		int rightMostDigit = (int) ((temp - leftOvers) * 10);
		return Long.parseLong(rightMostDigit + "" + leftOvers);
	}

	static public void main(String args[]) {
		long i = new ShiftRight().apply(1234);
		System.out.println(i);
	}
}
