package com.lmig.gfc.models;

import java.util.Stack;

public class MultiplyTwoNumbersTogether extends TwoNumberCalculation {

	
	public MultiplyTwoNumbersTogether(Stack<Double> stack) {
		super(stack);

	}

	@Override
	protected double doMath(double first, double second) {
		return second * first;
	}

}
