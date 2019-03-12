package com.calc.operations;

import com.calc.operations.modifier.Modifier;
import com.calc.solver.exception.InvalidResultException;

public interface Modifable<T extends Operation> {
	public T mod(T opertion, Modifier mod) throws InvalidResultException;
}
