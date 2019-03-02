package com.calc.operations;

import com.calc.solver.exception.InvalidResultException;

public abstract class Operation {
	public abstract long apply(long x) throws InvalidResultException;
}
