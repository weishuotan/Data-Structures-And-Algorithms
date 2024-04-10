package com.atguigu.linkedlist;

import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {
		Stack<String> stack = new Stack();
		//入栈
		stack.push("jack");
		stack.push("tom");
		stack.push("smith");
		
		//出栈
		while(stack.size() > 0) {
			System.out.printf(stack.pop()+"\n");
		}
		
	}

}
