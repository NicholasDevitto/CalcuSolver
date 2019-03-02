package com.calc.operations;

public class Mirror extends Operation {
	@Override
	public long apply(long x) {
		/*
		if (String.valueOf(x).length() >= 4) {
			return 999999999;
		}
		*/
		return Long.parseLong(String.valueOf(x) + reverse(x));
	}

	private String reverse(long x) {
		x = Math.abs(x);
		return new StringBuilder(String.valueOf(x)).reverse().toString();
	}

	static public void main(String[] args) {
		System.out.println(new Mirror().apply(-11));
	}

	@Override
	public String toString() {
		return "(mirror)";
	}
}
