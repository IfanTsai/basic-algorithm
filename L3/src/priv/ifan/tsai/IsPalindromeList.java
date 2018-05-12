package priv.ifan.tsai;

import java.util.Stack;

/*
 * 判断一个链表是否为回文结构
 * 
 * 题目: 
 * 给定一个链表的头结点head,请判断该链表是否为回文结构
 * 例如:
 * 1->2->1, 返回true
 * 1->2->2->1, 返回true
 * 15->6->15, 返回true
 * 1->2->3, 返回false
 * 
 * 进阶:
 * 如果链表长度为N,时间复杂度达到O(N),额外空间复杂度达到O(1)
 */
public class IsPalindromeList {
	
	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(2);
		node.next.next.next = new Node(1);
		System.out.println(isPalindrome1(node));
		System.out.println(isPalindrome2(node));
		System.out.println(isPalindrome3(node));
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	static class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	// need n extra space
	private static boolean isPalindrome1(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node tHead = head;
		while (tHead != null) {
			stack.push(tHead);
			tHead = tHead.next;
		}
		
		while (head != null) {
			if (head.data != stack.pop().data) {
				return false;
			}
			head = head.next;
		}
		
		return true;
	}
	
	// need n/2 extra space
	private static boolean isPalindrome2(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node slow = head;
		Node fast = head;
		// 每次快指针移动两步,慢指针移动一步,当快指针移动完的时候,慢指针指向的就是中间位置
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		while (slow != null) {
			stack.push(slow);
			slow = slow.next;
		}
		
		while (!stack.isEmpty()) {
			if (head.data != stack.pop().data) {
				return false;
			}
			head = head.next;
		}
		
		return true;
	}
	
	// need O(1) extra space
	/*
	 * 利用快慢指针法找到中间位置,然后将右半部分链表反转后进行比较,比较后将链表重新调整回来
	 */
	private static boolean isPalindrome3(Node head) {
		// find middle position
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// reverse
		Node temp = null;      // next node
		fast = null;           // prev node
		while (slow != null) { // current node != null
			temp = slow.next;  // save next node
			slow.next = fast;  // current node point to prev node (first: treat null is prev node)
			fast = slow;       // update prev node to current node
			slow = temp;       // update current node to next node
		}
		
		
		temp = fast;   // save the list's head after the reverse
		// compare
		boolean res = true;
		slow = head;
		while (fast != null) {
			if (slow.data != fast.data) {
				res = false;
				break;
			}
			slow = slow.next;
			fast = fast.next;
		}
		
		
		slow = temp; 
		// reset, the process is the same as reverse
		fast = null;
		temp = null;
		while (slow != null) {
			temp = slow.next;
			slow.next = fast;
			fast = slow;
			slow = temp;
		}
		
		return res;
	
	}

}
