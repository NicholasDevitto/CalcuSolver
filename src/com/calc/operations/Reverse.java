package com.calc.operations;

public class Reverse extends Operation {

	@Override
	public long apply(long x) {
		boolean positive = x >= 0;
		StringBuilder sp = new StringBuilder(String.valueOf(Math.abs(x))).reverse();
		if (!positive) {
			sp.insert(0, "-");
		}
		return Long.parseLong(sp.toString());
	}

	static public void main(String args[]) {
		System.out.println(new Reverse().apply(-21));
	}

}
