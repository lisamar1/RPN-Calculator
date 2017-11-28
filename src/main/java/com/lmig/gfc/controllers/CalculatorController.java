package com.lmig.gfc.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.models.AbsoluterOfOneNumber;
import com.lmig.gfc.models.AddTwoNumbersTogether;
import com.lmig.gfc.models.DivideTwoNumbersTogether;
import com.lmig.gfc.models.ExponentTwoNumbersTogether;
import com.lmig.gfc.models.Godoer;
import com.lmig.gfc.models.ItDoesThePushing;
import com.lmig.gfc.models.MultiplyTwoNumbersTogether;
import com.lmig.gfc.models.OneArgumentUndoer;
import com.lmig.gfc.models.SubtractTwoNumbersTogether;
import com.lmig.gfc.models.TwoNumberCalculation;
import com.lmig.gfc.models.Undoer;

@Controller
public class CalculatorController {

	private Stack<Double> stack;
	private Stack<Godoer> undoers;
	private Stack<Godoer> redoers;

	public CalculatorController() {
		stack = new Stack<Double>();
		undoers = new Stack<Godoer>();
		redoers = new Stack<Godoer>();

	}

	@GetMapping("/")
	public ModelAndView showCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("stack", stack);
		mv.addObject("hasOneOrMoreNumbers", stack.size() >= 1);
		mv.addObject("hasTwoOrMoreNumbers", stack.size() >= 2);
		mv.addObject("hasUndoer", undoers.size() > 0);
		mv.addObject("hasRedoer", redoers.size() > 0);
		return mv;
	}

	@PostMapping("/enter")
	public ModelAndView pushNumberOntoStack(double value) {
		ItDoesThePushing pusher = new ItDoesThePushing(stack, value);
		return doOperation(pusher);

	}

	@PostMapping("/abs")
	public ModelAndView absoluteValue() {
		AbsoluterOfOneNumber absoluter = new AbsoluterOfOneNumber(stack);
		return doOperation(absoluter);

	}

	@PostMapping("/add")
	public ModelAndView addTwoNumbers() {
		AddTwoNumbersTogether adder = new AddTwoNumbersTogether(stack);
		return doOperation(adder);
	}

	@PostMapping("/minus")
	public ModelAndView subtractTwoNumbers() {
		SubtractTwoNumbersTogether minuser = new SubtractTwoNumbersTogether(stack);
		return doOperation(minuser);

	}

	@PostMapping("/divide")
	public ModelAndView divideTwoNumbers() {
		DivideTwoNumbersTogether divider = new DivideTwoNumbersTogether(stack);
		return doOperation(divider);
	}

	@PostMapping("/multiply")
	public ModelAndView multiplyTwoNumbers() {
		MultiplyTwoNumbersTogether multiply = new MultiplyTwoNumbersTogether(stack);
		return doOperation(multiply);
	}

	@PostMapping("/exponent")
	public ModelAndView exponentTwoNumbers() {
		ExponentTwoNumbersTogether exponent = new ExponentTwoNumbersTogether(stack);
		return doOperation(exponent);

	}

	@PostMapping("/undo")
	public ModelAndView undo() {
		Godoer undoer = undoers.pop();
		undoer.undo(stack);
		redoers.push(undoer);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@PostMapping("/redo")
	public ModelAndView redo() {
		Godoer godoer = redoers.pop();
		godoer.goDoIt();
		undoers.push(godoer);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	private ModelAndView doOperation(Godoer calcy) {
		calcy.goDoIt();
		undoers.push(calcy);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;

	}
}
