package Stacks;

import java.util.Stack;

public class StackProblems {

	Stack<Character> stack = new Stack<Character>();

	public boolean isValidSymbolPattern(String s) {
		if (s == null || s.length() == 0)
			return true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else
					return false;
			} else if (s.charAt(i) == '}') {
				if (!stack.isEmpty() && stack.peek() == '{')
					stack.pop();
				else
					return false;
			} else if (s.charAt(i) == ']') {
				if (!stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else
					return false;
			} else
				stack.push(s.charAt(i));
		}

		if (stack.isEmpty() == true)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackProblems s = new StackProblems();
		System.out.println(s.isValidSymbolPattern("[[}]"));

	}

}
