
package com.lmig.gfc.rpn.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.models.DivideTwoNumbersTogether;
import com.lmig.gfc.models.ExponentTwoNumbersTogether;

public class ExponentTwoNumbersTogetherTests {
	private Stack<Double> stack;
	private ExponentTwoNumbersTogether exponent;

	@Before
	public void setUp() {
		stack = new Stack<Double>();
		exponent = new ExponentTwoNumbersTogether(stack);
	}
	@Test
	public void goDoIt_exponent_two_numbers_in_the_stack() {
	
		//Arrange
	Stack<Double> stack = new Stack<Double>();
	ExponentTwoNumbersTogether exponent = new ExponentTwoNumbersTogether(stack);
	stack.push(2d);
	stack.push(10d);
	
	//Act
	exponent.goDoIt();
	
	//Assert
	assertThat(stack).hasSize(1); 
	assertThat(stack.peek()).isEqualTo(100d);	
	}	
	
	@Test
	public void undo_returns_the_stack_to_the_previous_state() {

		// Arrange
		stack.push(10d);
		stack.push(2d);
		exponent.goDoIt();

		// Act (normally 1 line of code)
		exponent.undo(stack);

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
		exponent.goDoIt();

		// Assert
		fail("Did not throw an EmptyStackException");
	} catch (EmptyStackException ese) {

	}
}

@Test
public void null_stack_causes_NullPointerException_in_goDoIt() {

	// Arrange
	exponent = new ExponentTwoNumbersTogether(null);

	try {
		// Act
		exponent.goDoIt();

		// Assert
		fail("Somehow, this did not throw an NPE.");
	} catch (NullPointerException npe) {
	}

}
}
	
	
	

