package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.models.DivideTwoNumbersTogether;
import com.lmig.gfc.models.MultiplyTwoNumbersTogether;
import com.lmig.gfc.models.SubtractTwoNumbersTogether;

public class SubtractTwoNumbersTogetherTests {
	private Stack<Double> stack;
	private SubtractTwoNumbersTogether subtract;

	@Before
	public void setUp() {
		stack = new Stack<Double>();
		subtract = new SubtractTwoNumbersTogether(stack);
	}
	@Test
	public void goDoIt_subtract_two_numbers_in_the_stack() {

		// Arrange
		Stack<Double> stack = new Stack<Double>();
		SubtractTwoNumbersTogether subtract = new SubtractTwoNumbersTogether(stack);
		stack.push(20d);
		stack.push(10d);

		// Act
		subtract.goDoIt();

		// Assert
		assertThat(stack).hasSize(1);
		assertThat(stack.peek()).isEqualTo(10d);
	}
	@Test
	public void undo_returns_the_stack_to_the_previous_state() {

		// Arrange
		stack.push(10d);
		stack.push(2d);
		subtract.goDoIt();

		// Act (normally 1 line of code)
		subtract.undo(stack);

		// Assert
		assertThat(stack.pop()).isEqualTo(2d);
		assertThat(stack.pop()).isEqualTo(10d);
	}

@Test
public void empty_stack_causes_goDoIt_to_throw_EmptyStackException() {
	// Arrange
	// Already arranged because stack is empty

	try {
		// Act
		subtract.goDoIt();

		// Assert
		fail("Did not throw an EmptyStackException");
	} catch (EmptyStackException ese) {

	}
}

@Test
public void null_stack_causes_NullPointerException_in_goDoIt() {

	// Arrange
	subtract = new SubtractTwoNumbersTogether(null);

	try {
		// Act
		subtract.goDoIt();

		// Assert
		fail("Somehow, this did not throw an NPE.");
	} catch (NullPointerException npe) {
	}

}

}
