package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.models.DivideTwoNumbersTogether;
import com.lmig.gfc.models.MultiplyTwoNumbersTogether;

public class MultiplyTwoNumbersTogetherTests {
	private Stack<Double> stack;
	private MultiplyTwoNumbersTogether multiply;

	@Before
	public void setUp() {
		stack = new Stack<Double>();
		multiply = new MultiplyTwoNumbersTogether(stack);
	}
	
	@Test
	public void goDoIt_multiply_two_numbers_in_the_stack() {
	
		//Arrange
	Stack<Double> stack = new Stack<Double>();
	MultiplyTwoNumbersTogether multiply = new MultiplyTwoNumbersTogether(stack);
	stack.push(2d);
	stack.push(2d);
	
	//Act
	multiply.goDoIt();
	
	//Assert
	assertThat(stack).hasSize(1); 
	assertThat(stack.peek()).isEqualTo(4d);	
	}	
	@Test
	public void undo_returns_the_stack_to_the_previous_state() {

		// Arrange
		stack.push(10d);
		stack.push(2d);
		multiply.goDoIt();

		// Act (normally 1 line of code)
		multiply.undo(stack);

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
		multiply.goDoIt();

		// Assert
		fail("Did not throw an EmptyStackException");
	} catch (EmptyStackException ese) {

	}
}

@Test
public void null_stack_causes_NullPointerException_in_goDoIt() {

	// Arrange
	multiply = new MultiplyTwoNumbersTogether(null);

	try {
		// Act
		multiply.goDoIt();

		// Assert
		fail("Somehow, this did not throw an NPE.");
	} catch (NullPointerException npe) {
	}

}
}


