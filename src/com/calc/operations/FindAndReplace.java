package com.calc.operations;

public class FindAndReplace extends Operation {
	private int find;
	private int replace;

	public FindAndReplace(int find, int replace) {
		super();
		this.find = find;
		this.replace = replace;
	}

	@Override
	public long apply(long x) {
		return Long.parseLong(String.valueOf(x).replaceAll(String.valueOf(find),
				String.valueOf(replace)));
	}

	@Override
	public String toString() {
		return find + "=>" + replace;
	}

	public static void main(String[] args) {
		Long i = new FindAndReplace(21, 3).apply(2121);
		System.out.println(i);
	}

}
