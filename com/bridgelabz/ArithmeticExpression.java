package com.bridgelabz;

import java.util.Scanner;
import java.util.Stack;

public class ArithmeticExpression {
	public static void main(String[] args) {
		Stack<Character> stack=new Stack<Character>();
		Scanner sc=new Scanner(System.in);
		String expresion=sc.next();
		char expn[]=expresion.toCharArray();
		for(int i=0;i<expn.length;i++){
			if(expn[i]=='('){
				stack.push(expn[i]);
			}else if(expn[i]==')'){
				if(stack.isEmpty()){
					stack.push(expn[i]);
					break;
				}
				stack.pop();
			}
		}
		System.out.println(stack.isEmpty());
	}


}
