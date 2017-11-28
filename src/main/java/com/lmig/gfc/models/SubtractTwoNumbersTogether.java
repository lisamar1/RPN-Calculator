package com.lmig.gfc.models;

import java.util.Stack;

public class SubtractTwoNumbersTogether extends TwoNumberCalculation {

	public SubtractTwoNumbersTogether(Stack<Double> stack) {
		super(stack);

	}

	@Override
	protected double doMath(double first, double second) {
		return second - first;
	}
}
