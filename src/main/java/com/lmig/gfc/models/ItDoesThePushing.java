package com.lmig.gfc.models;

import java.util.Stack;

public class ItDoesThePushing implements Godoer, Undoer {

	private Stack<Double> stack;
	private double valueToPush;

	public ItDoesThePushing(Stack<Double> stack, double valueToPush) {
		this.stack = stack;
		this.valueToPush = valueToPush;

	}

	@Override
	public void undo(Stack<Double> stack) {
		stack.pop();

	}

	@Override
	public void goDoIt() {
		stack.push(valueToPush);

	}

}
