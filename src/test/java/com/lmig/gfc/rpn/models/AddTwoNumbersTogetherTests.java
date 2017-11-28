package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.models.AbsoluterOfOneNumber;
import com.lmig.gfc.models.AddTwoNumbersTogether;

public class AddTwoNumbersTogetherTests {
	private Stack<Double> stack;
	private AddTwoNumbersTogether add;

	@Before
	public void setUp() {
		stack = new Stack<Double>();
		add = new AddTwoNumbersTogether(stack);
	}

	@Test
	public void goDoIt_adds_two_numbers_in_the_stack_together() {

		// Arrange
		Stack<Double> stack = new Stack<Double>();
		AddTwoNumbersTogether add = new AddTwoNumbersTogether(stack);
		stack.push(2d);
		stack.push(3d);

		// Act
		add.goDoIt();

		// Assert
		assertThat(stack).hasSize(1);
		assertThat(stack.peek()).isEqualTo(5d);

	}

	@Test
	public void undo_returns_the_stack_to_the_previous_state() {

		// Arrange
		stack.push(2d);
		stack.push(3d);
		add.goDoIt();

		// Act (normally 1 line of code)
		add.undo(stack);

		// Assert
		assertThat(stack.pop()).isEqualTo(3d);
		assertThat(stack.pop()).isEqualTo(2d);
	}

	@Test
	public void empty_stack_causes_goDoIt_to_throw_EmptyStackException() {
		// Arrange
		// Already arranged because stack is empty

		try {
			// Act
			add.goDoIt();

			// Assert
			fail("Did not throw an EmptyStackException");
		} catch (EmptyStackException ese) {

		}
	}

	@Test
	public void null_stack_causes_NullPointerException_in_goDoIt() {

		// Arrange
		add = new AddTwoNumbersTogether(null);

		try {
			// Act
			add.goDoIt();

			// Assert
			fail("Somehow, this did not throw an NPE.");
		} catch (NullPointerException npe) {
		}

	}

}
