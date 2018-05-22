
// 把一棵搜索二叉树， 转化成有序的双向链表。

public class BSTtoDoubleLinkedList {
	static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int value) {
			this.value = value;
		}
	}

	// return the head of the DoubleLinkedList come from SerachTree
	public static Node convert1(Node root) {
		if (root == null) {
			return null;
		}
		return process1(root);
	}

	public static Node process1(Node head) {
		// base case
		if (head == null) {
			return null;
		}
		Node leftSub = process1(head.left);    // recursive left 
		Node rightSub = process1(head.right);  // recursive rightt 
		head.left = head.right = null;
		if (leftSub != null) {
			Node cur = leftSub;
			// find the last node of leftSub
			while (cur.right != null) {
				cur = cur.right;
			}
			// connect leftSub and head
			cur.right = head;
			head.left = cur;
		}
		if (rightSub != null) {
			// connect head and rightSub
			head.right = rightSub;
			rightSub.left = head;
		}
		// return the non-empty head of the list
		return leftSub != null ? leftSub : head;
	}
	
	public static Node convert2(Node root) {
		if (root == null) {
			return null;
		}
		return process2(root)[0];
	}

	public static Node[] process2(Node head) {
		// base case
		if (head == null) {
			return new Node[] { null, null };
		}
		Node[] leftSub = process2(head.left);
		Node[] rightSub = process2(head.right);
		head.left = head.right = null;
		if (leftSub[1] != null) {
			leftSub[1].right = head;
			head.left = leftSub[1].right;
		}
		if (rightSub[0] != null) {
			head.right = rightSub[0];
			rightSub[0].left = head;
		}
		// return the non-empty head and tail of the list
		leftSub[0] = leftSub[0] != null ? leftSub[0] : head;
		rightSub[1] = rightSub[1] != null ? rightSub[1] : head;
		return new Node[] { leftSub[0], rightSub[1] };
	} 
	
	public static void main(String[] args) {
		/*
		 *                  4
		 *           2              5
		 *       1       3      6       7
		 *                                  8
		 */
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		
		Node head = convert2(root);
		while (head != null) {	
			System.out.print(head.value + ", ");
			head = head.right;
		}
	}
}
