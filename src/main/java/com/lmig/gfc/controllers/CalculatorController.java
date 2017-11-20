package com.lmig.gfc.controllers;

import java.util.Stack;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.models.OneArgumentUndoer;
import com.lmig.gfc.models.TwoArgumentUndoer;

@Controller
public class CalculatorController {

	private Stack<Double> stack;
	private OneArgumentUndoer undoer;

	public CalculatorController() {
		stack = new Stack<Double>();
	}

	@GetMapping("/")
	public ModelAndView showCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("stack", stack);
		mv.addObject("hasTwoOrMoreNumbers", stack.size() >= 2);
		mv.addObject("hasUndoer", undoer != null);
		return mv;
	}

	@PostMapping("/enter")
	public ModelAndView pushNumberOntoStack(double value) {
		stack.push(value);
		undoer = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@PostMapping("/abs")
	public ModelAndView absoluteValue() {
		double value = stack.pop();
		undoer = new OneArgumentUndoer(value);
	//	double result = Math.abs(value);
		if (value < 0) {
			value = -1 * value;
		}
		stack.push(value);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView addTwoNumbers() {
		double first = stack.pop();
		double second = stack.pop();
		double result = first + second;
		stack.push(result);
		undoer = new TwoArgumentUndoer(first, second);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@PostMapping("/minus")
	public ModelAndView subtractTwoNumbers() {
		double first = stack.pop();
		double second = stack.pop();
		double result = second - first;
		stack.push(result);
		undoer = new TwoArgumentUndoer(first, second);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@PostMapping("/undo")
	public ModelAndView undo() {
		undoer.undo(stack);
		undoer = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
}


