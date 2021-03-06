package com.coding.basic.stack.expr;

import java.util.List;
import java.util.Stack;


public class PostfixExpr {
	String expr = null;
	
	public PostfixExpr(String expr) {
		this.expr = expr;
	}

	public float evaluate() {
		Stack<String> stack = new Stack<String>();
		TokenParser parser = new TokenParser();
		List<Token> tokens  = parser.parse(expr);
		for(Token token :tokens){
			if(token.isNumber()){
				stack.push(token.toString());
			}
			if(token.isOperator()){
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				String result = parseToResult(num1,num2,token.toString());
				stack.push(result);
			}
		}
		
		
		
		return Float.parseFloat(stack.pop());
	}
	
	private String parseToResult(int num1, int num2, String oper) {
		// TODO Auto-generated method stub
		String result = "";
		if(oper.equals("*"))
			result = (num1*num2)+"";
		if(oper.equals("/"))
			result = (num2/num1)+"";
		if(oper.equals("+"))
			result = (num1+num2)+"";
		if(oper.equals("-"))
			result = (num2-num1)+"";
		return result;
	}

	public static void main(String[] args) {
		//9+(3-1)*3+10/2
		PostfixExpr pos = new PostfixExpr("9 3 1-3*+ 10 2/+");
		float f =pos.evaluate();
		System.out.println(f);
	}
}
