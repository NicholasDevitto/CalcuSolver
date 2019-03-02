package com.calc.operations;

public class ShiftLeft extends Operation {

	@Override
	public long apply(long x) {
		char[] digits = String.valueOf(x * 10).toCharArray();
		digits[digits.length - 1] = digits[0];
		digits[0] = '0';
		return Integer.parseInt(String.valueOf(digits));
	}

	@Override
	public String toString() {
		return "(ShiftLeft)";
	}

	static public void main(String[] args) {
		System.out.println(new ShiftLeft().apply(123));
	}
}
