package priv.ifan.tsai;

/*
 * 反转单向和双向链表
 * 
 * 题目:
 * 分别实现反转单向链表和反转双向链表的函数
 * 
 * 要求:
 * 如果链表长度为N,时间复杂度要求为O(N),额外空间复杂度要求为O(1)
 */
public class ReverseList {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node = reverseList(node);
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
	
	private static Node reverseList(Node head) {
		Node prev = null;
		Node next = null;
		while (head != null) {
			next = head.next;     // save next node
			head.next = prev;     // current note point to prev node  (first: prev node is null)
			prev = head;          // update prev node to current node
			head = next;          // update prev node to next node
		}
		return prev;
	}
	
	static class DoubleNode {
		public int data;
		public DoubleNode next;
		public DoubleNode prev;
		
		public DoubleNode(int data) {
			this.data = data;
		}
	}
	
	@SuppressWarnings("unused")
	private static DoubleNode reverseList(DoubleNode head) {
		DoubleNode prev = null;
		DoubleNode next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			head.prev = next;
			prev = head;
			head = next;
		}
		return prev;
	}
	
}
