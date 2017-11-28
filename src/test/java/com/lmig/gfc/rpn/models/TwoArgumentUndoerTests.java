package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.models.AbsoluterOfOneNumber;
import com.lmig.gfc.models.AddTwoNumbersTogether;
import com.lmig.gfc.models.TwoArgumentUndoer;

public class TwoArgumentUndoerTests {

	private Stack<Double> stack;
	private TwoArgumentUndoer undo;

	@Before
	public void setUp() {
		stack = new Stack<Double>();
		undo = new TwoArgumentUndoer(4,3);
	}
	@Test
	public void undo_returns_the_stack_to_the_previous_state() {

		// Arrange

		stack.push(12d);
		
		// Act (normally 1 line of code)
		undo.undo(stack);
		
		// Assert

		assertThat(stack.pop()).isEqualTo(4d);
		assertThat(stack.pop()).isEqualTo(3d);
	}
}
