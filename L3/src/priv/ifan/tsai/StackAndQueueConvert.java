package priv.ifan.tsai;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 仅用队列结构实现栈结构;
 * 仅用栈结构实现队列结构
 */
public class StackAndQueueConvert {

	public static void main(String[] args) {
		TwoQueueStack stack = new TwoQueueStack();
		stack.push(11);
		stack.push(12);
		stack.push(13);
		stack.push(14);
		stack.push(15);
		stack.push(16);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		
		TwoStackQueue queue = new TwoStackQueue();
		queue.add(11);
		queue.add(12);
		queue.poll();
		queue.add(13);
		queue.add(14);
		queue.add(15);
		queue.poll();
		queue.add(16);
		queue.add(17);
		queue.add(18);
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
		
	}
	
	static class TwoQueueStack {
		private Queue<Integer> queue;
		private Queue<Integer> help;
		
		public TwoQueueStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}
		
		public boolean isEmpty() {
			return queue.isEmpty();
		}
		
		public void push(int obj) {
			queue.add(obj);
		}
		
		public int pop() {
			if (isEmpty()) {
				throw new RuntimeException("The stack is empty");
			}
			while (queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			swap(); // 交换引用
			return res;
		}
		
		public int peek() {
			if (isEmpty()) {
				throw new RuntimeException("The stack is empty");
			}
			while (queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);
			swap(); // 交换引用
			return res;
		}

		// 交换引用
		private void swap() {
			Queue<Integer> t = queue;
			queue = help;
			help = t;
		}
	}
	
	static class TwoStackQueue { 
		private Stack<Integer> pushStack;  // 入队往push栈中入队
		private Stack<Integer> popStack;   // 出队从pop栈中出队
		
		public TwoStackQueue() {
			pushStack = new Stack<Integer>();
		    popStack = new Stack<Integer>();
		}
		
		public boolean isEmpty() {
			return pushStack.isEmpty() && popStack.isEmpty();
		}
		
		public void add(int obj) {
			pushStack.add(obj);
		}
		
		public int poll() {
			if (isEmpty()) {
				throw new RuntimeException("The stack is empty");
			}
			
			decant();  // 倒数
			
			return popStack.pop();
		}
		
		public int peek() {
			if (isEmpty()) {
				throw new RuntimeException("The stack is empty");
			}
			
			decant();  // 倒数
			
			return popStack.peek();
		}

		/*
		 * 将push栈中的数倒入到pop栈中
		 * 该操作时机不重要,但一定要遵循两个规则:
		 * 1. 只有当pop栈为空才可以倒入
		 * 2. 要倒就要把push栈中的数倒光
		 */
		private void decant() {
			if (popStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					popStack.push(pushStack.pop());
				}
			}
		}
			
	}
}
