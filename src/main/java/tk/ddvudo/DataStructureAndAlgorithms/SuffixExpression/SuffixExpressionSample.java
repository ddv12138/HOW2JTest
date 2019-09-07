package tk.ddvudo.DataStructureAndAlgorithms.SuffixExpression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SuffixExpressionSample {
	private static Logger logger = LoggerFactory.getLogger(SuffixExpressionSample.class.getName());

	public static void main(String... args) {
		String Expression = "(46+5*(120-37))/(46+5*(120-37))*(46+5*(120-37))/(46+5*(120-37))+(5-10)/(1+5-(2+3))";
		logger.info(Expression);
		String suffixExpression = getSuffixExpression(Expression);
		logger.info(suffixExpression);
		double value = computeSuffixExperession(suffixExpression);
		logger.info(value + "");
	}

	private static String getSuffixExpression(String expression) {
		StringBuilder res = new StringBuilder();
		expression = expression.replaceAll(" ", "");
		Map<Character, Integer> rule = new HashMap<>();
		rule.put('+', 0);
		rule.put('-', 0);
		rule.put('*', 1);
		rule.put('/', 1);
		Stack<Character> signStack = new Stack<>();
		for (int i = 0; i < expression.toCharArray().length; i++) {
			char c = expression.charAt(i);
			if (c >= '0' && c <= '9') {
				res.append(c);
				if (expression.length() > i + 1) {
					char next_c = expression.charAt(i + 1);
					if (!(next_c >= '0' && next_c <= '9')) {
						res.append(" ");
					}
				} else if (expression.length() == i + 1) {
					res.append(" ");
				}
			} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
				if (signStack.isEmpty()) {
					signStack.push(c);
				} else {
					if (c == ')') {
						while (!signStack.isEmpty()) {
							if (signStack.peek() != '(') {
								res.append(signStack.pop()).append(" ");
							} else {
								signStack.pop();
								break;
							}
						}
					} else {
						while (!signStack.isEmpty() && rule.containsKey(c) && rule.containsKey(signStack.peek())
								&& rule.get(c) < rule.get(signStack.peek())) {
							res.append(signStack.pop()).append(" ");
						}
						signStack.push(c);
					}
				}
			}
		}
		while (!signStack.isEmpty()) {
			res.append(signStack.pop()).append(" ");
		}
		return res.toString().replaceAll("\\(", "")
				.replaceAll("\\)", "")
				.replaceAll(" {2}", " ");
	}

	private static double computeSuffixExperession(String SuffixExpression) {
		Stack<Double> stack = new Stack<>();
		String[] expressionArr = SuffixExpression.split(" ");
		for (String s : expressionArr) {
			if (isdigit(s)) {
				stack.push(Double.valueOf(s));
			} else {
				switch (s) {
					case "+":
						double b = stack.pop();
						double a = stack.pop();
						double c = a + b;
						logger.info("computing " + a + s + b + "=" + c);
						stack.push(c);
						break;
					case "-":
						b = stack.pop();
						a = stack.pop();
						c = a - b;
						logger.info("computing " + a + s + b + "=" + c);
						stack.push(c);
						break;
					case "*":
						b = stack.pop();
						a = stack.pop();
						c = a * b;
						logger.info("computing " + a + s + b + "=" + c);
						stack.push(c);
						break;
					case "/":
						b = stack.pop();
						a = stack.pop();
						c = a / b;
						logger.info("computing " + a + s + b + "=" + c);
						stack.push(c);
						break;
				}
			}
		}
		return stack.pop();
	}

	private static boolean isdigit(String s) {
		for (char c : s.toCharArray()) {
			if (!(c >= '0' && c <= '9')) {
				return false;
			}
		}
		return true;
	}
}
