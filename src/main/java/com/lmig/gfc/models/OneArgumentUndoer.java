package com.lmig.gfc.models;

import java.util.Stack;

public class OneArgumentUndoer {
	
private double first; 

public OneArgumentUndoer(double first) {
	this.first = first;
}

public void undo(Stack<Double> stack) {
	stack.pop();
	parentUndo(stack);
}
protected void parentUndo(Stack<Double> stack) {
	stack.push(first);
}
}

	
