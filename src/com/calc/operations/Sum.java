package com.calc.operations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sum extends Operation {

	@Override
	public long apply(long x) {
		int sum = 0;
		Pattern pattern = Pattern.compile("-[0-9]|[0-9]");
		Matcher matcher = pattern.matcher(String.valueOf(x));

		while (matcher.find()) {
			String digit = matcher.group();
			sum += Integer.parseInt(String.valueOf(digit));
		}

		return sum;
	}

	static public void main(String[] args) {
		System.out.println(new Sum().apply(-123));
	}

	@Override
	public String toString() {
		return "(sum)";
	}
}
