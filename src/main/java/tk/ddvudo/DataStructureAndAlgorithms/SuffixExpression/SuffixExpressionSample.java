package tk.ddvudo.DataStructureAndAlgorithms.SuffixExpression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class SuffixExpressionSample {
    private static Logger logger = LoggerFactory.getLogger(SuffixExpressionSample.class.getName());

    public static void main(String... args) {
        String Expression = "46+5*(120-37)";
        String suffixExpression = getSuffixExpression(Expression);
        logger.info(suffixExpression);
    }

    private static String getSuffixExpression(String expression) {
        String res = "";
        Stack<Character> signStack = new Stack<Character>();
        expression = expression.replaceAll(" ", "");
        String rule = "+-_*/_()";
        for (int i = 0; i < expression.toCharArray().length; i++) {
            char c = expression.charAt(i);
            if (c >= '0' && c <= '9') {
                res += c;
                if (expression.length() > i + 1) {
                    char next_c = expression.charAt(i + 1);
                    if (!(next_c >= '0' && next_c <= '9')) {
                        res += " ";
                    }
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                if (signStack.isEmpty()) {
                    signStack.push(c);
                } else {
                    char signTop = signStack.peek();
                    if (c == ')') {
                        while (!signStack.isEmpty() && signStack.peek() != '(') {
                            res += signStack.pop() + " ";
                        }
                    } else if (rule.indexOf((signTop)) > 0 && rule.indexOf(c) < rule.indexOf(signTop) && signTop != '(' && signTop != ')') {
                        char tmpsignTop = signStack.peek();
                        while (!signStack.isEmpty() && rule.indexOf(c) < rule.indexOf(tmpsignTop)) {
                            tmpsignTop = signStack.pop();
                            res += tmpsignTop + " ";
                        }
                    } else {
                        signStack.push(c);
                    }
                }
            }
        }
        while (!signStack.isEmpty()) {
            if (signStack.peek() != '(' && signStack.peek() != ')') {
                res += signStack.pop() + " ";
            } else {
                signStack.pop();
            }
        }
        return res.replaceAll("\\(", "").replaceAll("\\)", "");
    }
}
