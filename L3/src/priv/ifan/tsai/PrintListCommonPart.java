package priv.ifan.tsai;

/*
 * 打印两个有序链表的公共部分
 * 
 * 题目:
 * 给定两个有序链表的头指针head1和head2,打印两个链表的公共部分
 *
 */
public class PrintListCommonPart {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		node1.next = new Node(3);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(6);
		node1.next.next.next.next = new Node(9);
		
		Node node2 = new Node(1);
		node2.next = new Node(2);
		node2.next.next = new Node(5);
		node2.next.next.next = new Node(7);
		node2.next.next.next.next = new Node(9);
		
		printCommonPart(node1, node2);
	}
	
	static class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	private static void printCommonPart(Node head1, Node head2) {
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				head1 = head1.next;
			} else if (head1.data > head2.data) {
				head2 = head2.next;
			} else {
				System.out.print(head1.data + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
	}
	
}
