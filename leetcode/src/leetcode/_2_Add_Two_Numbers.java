package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _2_Add_Two_Numbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode addStrings(String num1, String num2) {
		Queue<Character> queue = new LinkedList<Character>();
		int co = 0;
		int i = num1.length() - 1, j = num2.length() - 1;
		int t = 0;
		while (i >= 0 && j >= 0) {
			t = (num1.charAt(i--) - '0') + (num2.charAt(j--) - '0') + co;
			co = t >= 10 ? 1 : 0;
			t = t >= 10 ? t % 10 : t;
			queue.add((char) (t + '0'));
		}
		while (i >= 0) {
			t = (num1.charAt(i--) - '0') + co;
			co = t >= 10 ? 1 : 0; 
			t = t >= 10 ? t % 10 : t;
			queue.add((char) (t + '0'));
		}
		while (j >= 0) {
			t = (num2.charAt(j--) - '0') + co;
			co = t >= 10 ? 1 : 0; 
			t = t >= 10 ? t % 10 : t;
			queue.add((char) (t + '0'));
		}
		if (co == 1) {
			queue.add('1');
		}
		ListNode res = new ListNode(-1);
		ListNode cur = res;
		while (!queue.isEmpty()) {
			cur.next = new ListNode(queue.poll() - '0');
			cur = cur.next;
		}
		return res.next;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Character> stack = new Stack<Character>();
		ListNode cur = l1;
		while (cur != null) {
			stack.push((char) (cur.val + '0'));
			cur = cur.next;
		}
		char[] num1 = new char[stack.size()];
		for (int i = 0; i < num1.length; i++) {
			num1[i] = stack.pop();
		}
		
		cur = l2;
		while (cur != null) {
			stack.push((char) (cur.val + '0'));
			cur = cur.next;
		}
		char[] num2 = new char[stack.size()];
		for (int i = 0; i < num2.length; i++) {
			num2[i] = stack.pop();
		}
		
		return addStrings(String.valueOf(num1), String.valueOf(num2));
	}
	
	public static ListNode create(String str) {
		ListNode res = new ListNode(-1);
		ListNode cur = res;
		for (int i = 0; i < str.length(); i++) {
			cur.next = new ListNode(str.charAt(i) - '0');
			cur = cur.next;
		}
		return res.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = create("9");

		ListNode l2 = create("1999999999");
		

		
		ListNode res = addTwoNumbers(l1, l2);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
