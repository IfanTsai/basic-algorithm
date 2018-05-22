
/*
 * 给定一个链表list，
 * 如果：
 * list = 1 调整之后1。
 * list = 1->2 调整之后1->2
 * list = 1->2->3 调整之后1->2->3
 * list = 1->2->3->4 调整之后1->3->2->4
 * list = 1->2->3->4->5 调整之后1->3->2->4->5
 * list = 1->2->3->4->5->6 调整之后1->4->2->5->3->6
 * list = 1->2->3->4->5->6->7 调整之后1->4->2->5->3->6->7
 * 根据上面的规律， 调整一个任意长度的链表。
 */
public class AdjustList {
	static class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void adjust(Node head) {
		// 快慢指针法找到中间节点的前一个位置, fast初始时比slow多一步
		Node slow = head, fast = head.next;   
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// 将链表拆分成两个, 然后在这两个链表间进行调整
		Node cur1 = head;
		Node cur2 = slow.next;
		slow.next = null;
		while (cur1.next != null) {
			Node t1 = cur1.next;
			Node t2 = cur2.next;
			cur1.next = cur2;
			cur2.next = t1;
			cur1 = t1;
			cur2 = t2;
		}
		cur1.next = cur2;
	}
	
	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);   
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		adjust(head);
		printList(head);
	}
	
}
