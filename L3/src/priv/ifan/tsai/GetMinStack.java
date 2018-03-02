package priv.ifan.tsai;

import java.util.Stack;

/*
 * 实现一个特殊的栈,在实现栈的基本功能的基础上,再实现返回栈中最小元素的操作
 * 要求:
 * 1. pop,push,getMin操作的时间复杂度都为O(1)
 * 2. 设计的栈类型可以使用现成的栈结构
 */
public class GetMinStack {

	public static void main(String[] args) {
		HasMinValStack stack = new HasMinValStack();
		stack.push(2);
		System.out.print(stack.getMin() + " ");
		stack.push(3);
		stack.push(1);
		System.out.print(stack.getMin() + " ");
		stack.pop();
		System.out.print(stack.getMin() + " ");
		stack.push(10);
		stack.push(4);
		stack.push(2);
		System.out.print(stack.getMin()  + " ");
	}	
	
	static class HasMinValStack {
		// 准备存储数据的栈的基础上,再准备一个存放最小值的min栈
		Stack<Integer> dataStack;  
		Stack<Integer> minStack;
		
		public HasMinValStack() {
			dataStack = new Stack<Integer>();
			minStack = new Stack<Integer>();
		}
		
		public boolean isEmpty() {
			return dataStack.isEmpty();
		}
		
		// min栈为空,直接压栈;min栈不为空,当前值如果比min栈栈顶小,则压栈
		public void push(int obj) {
			dataStack.push(obj);
			if (minStack.isEmpty()) {
				minStack.push(obj);
			} else {
				if (obj < minStack.peek()) {
					minStack.push(obj);
				}
			}
		}
		
		// 数据栈出栈,min栈栈顶如果跟数据栈出栈的值一样,则min栈也出栈
		public int pop() {
			Integer data = dataStack.pop();
			if (data == minStack.peek()) {
				minStack.pop();
			}
			return data;
		}
		
		// min栈栈顶元素即为最小值
		public int getMin() {
			return minStack.peek();
		}
	}
}
