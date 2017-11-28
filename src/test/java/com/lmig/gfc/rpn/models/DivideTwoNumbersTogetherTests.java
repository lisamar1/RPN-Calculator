package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.models.DivideTwoNumbersTogether;

public class DivideTwoNumbersTogetherTests {
	private Stack<Double> stack;
	private DivideTwoNumbersTogether divide;

	@Before
	public void setUp() {
		stack = new Stack<Double>();
		divide = new DivideTwoNumbersTogether(stack);
	}

	@Test
	public void goDoIt_divide_two_numbers_in_the_stack() {

		// Arrange
		Stack<Double> stack = new Stack<Double>();
		DivideTwoNumbersTogether divide = new DivideTwoNumbersTogether(stack);
		stack.push(20d);
		stack.push(2d);

		// Act
		divide.goDoIt();

		// Assert
		assertThat(stack).hasSize(1);
		assertThat(stack.peek()).isEqualTo(10d);
	}

	@Test
	public void undo_returns_the_stack_to_the_previous_state() {

		// Arrange
		stack.push(10d);
		stack.push(2d);
		divide.goDoIt();

		// Act (normally 1 line of code)
		divide.undo(stack);

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
		divide.goDoIt();

		// Assert
		fail("Did not throw an EmptyStackException");
	} catch (EmptyStackException ese) {

	}
}

@Test
public void null_stack_causes_NullPointerException_in_goDoIt() {

	// Arrange
	divide = new DivideTwoNumbersTogether(null);

	try {
		// Act
		divide.goDoIt();

		// Assert
		fail("Somehow, this did not throw an NPE.");
	} catch (NullPointerException npe) {
	}

}
}