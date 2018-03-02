package priv.ifan.tsai;

/*
 * 将单向链表按某值划分成左边小、 中间相等、 右边大的形式
 * 
 * 题目:
 * 给定一个单向链表的头节点head, 节点的值类型是整型, 再给定一个整数pivot.
 * 实现一个调整链表的函数, 将链表调整为左部分都是值小于 pivot的节点， 
 * 中间部分都是值等于pivot的节点, 右部分都是值大于pivot的节点.
 * 除这个要求外, 对调整后的节点顺序没有更多的要求.
 * 
 * 进阶：
 * 在原问题的要求之上再增加如下两个要求。
 * 1. 在左、 中、 右三个部分的内部也做顺序要求, 要求每部分里的节点从左到右的顺序与原链表中节点的先后次序一致
 * 2. 如果链表长度为N, 时间复杂度请达到O(N), 额外空间复杂度请达到O(1)
 */
public class ListPartition {
	
	public static void main(String[] args) {
		Node node = new Node(5);
		node.next = new Node(2);
		node.next.next = new Node(4);
		node.next.next.next = new Node(11);
		node.next.next.next.next = new Node(9);
		node.next.next.next.next.next = new Node(7);
		node.next.next.next.next.next.next = new Node(8);
		node.next.next.next.next.next.next.next = new Node(7);
		node = partition1(node, 7);
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
		
		Node node1 = new Node(5);
		node1.next = new Node(2);
		node1.next.next = new Node(4);
		node1.next.next.next = new Node(11);
		node1.next.next.next.next = new Node(9);
		node1.next.next.next.next.next = new Node(7);
		node1.next.next.next.next.next.next = new Node(8);
		node1.next.next.next.next.next.next.next = new Node(7);
		node1 = partition2(node1, 7);
		while (node1 != null) {
			System.out.print(node1.data + " ");
			node1 = node1.next;
		}
	}

	static class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	// 普通: need extra O(n) space
	private static Node partition1(Node head, int pivot) {
		int len = 0;
		Node temp = head;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		Node[] nodes = new Node[len];
		temp = head;
		for (int i =  0; i < nodes.length; i++) {
			nodes[i] = temp;
			temp = temp.next;
		}
		int less = -1;
		int more = nodes.length;
		int i = 0;
		while (i < more) {
			if (nodes[i].data < pivot) {
				swap(nodes, ++less, i++);
			} else if (nodes[i].data > pivot) {
				swap(nodes, --more, i);
			} else {
				i++;
			}
		}
		for (i = 1; i < nodes.length; i++) {
			nodes[i - 1].next = nodes[i];
		}
		nodes[i - 1].next = null;
		return nodes[0];
	}

	private static void swap(Node[] nodes, int i, int j) {
		if (nodes[i] != nodes[j]) {
			Node temp = nodes[i];
			nodes[i] = nodes[j];
			nodes[j] = temp;
		}
	}
	
	// 进阶: need extra O(1) space, stable
	private static Node partition2(Node head, int pivot) {
		Node sH = null; // small链表头结点
		Node sT = null; // small链表尾结点
		Node eH = null; // equl链表头结点
		Node eT = null; // equl链表尾结点
		Node bH = null; // big链表头结点
		Node bT = null; // big链表尾结点
		Node temp;
		while (head != null) {
			temp = head.next;
			if (head.data < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;     
				}
			} else if (head.data > pivot) {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			} else {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			}
			head = temp;
		}
		sT.next = eH;
		eT.next = bH;
		bT.next = null;
		return sH;
	}
}
