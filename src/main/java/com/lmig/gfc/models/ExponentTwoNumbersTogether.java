package com.lmig.gfc.models;

import java.util.Stack;

public class ExponentTwoNumbersTogether extends TwoNumberCalculation {

	public ExponentTwoNumbersTogether(Stack<Double> stack) {
		super(stack);

	}

	@Override
	protected double doMath(double first, double second) {
		return Math.pow(first, second);
	}
}
