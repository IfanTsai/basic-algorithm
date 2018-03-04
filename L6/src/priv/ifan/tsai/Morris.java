package priv.ifan.tsai;

public class Morris {

	static class BinaryNode {
		public int data;
		public BinaryNode left;
		public BinaryNode right;
		
		public BinaryNode(int data) {
			this.data = data;
		}
	}
	
		private static void prevOrderTraverseR(BinaryNode root) {
			if (root != null) {
				System.out.print(root.data + " ");
				prevOrderTraverseR(root.left);
				prevOrderTraverseR(root.right);
			}
		}
		
		private static void inOrderTraverseR(BinaryNode root) {
			if (root != null) {
				inOrderTraverseR(root.left); 
				System.out.print(root.data + " ");
				inOrderTraverseR(root.right);
			}
		}
		
		private static void postOrderTraverseR(BinaryNode root) {
			if (root != null) {
				postOrderTraverseR(root.left);
				postOrderTraverseR(root.right);
				System.out.print(root.data + " ");
			}
		}
	
	public static void morrisPrev(BinaryNode root) {
		if (root == null) {
			return;
		}
		BinaryNode cur1 = root;
		BinaryNode cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					System.out.print(cur1.data + " ");
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			} else {
				System.out.print(cur1.data + " ");
			}
			cur1 = cur1.right;
		}
	}
	
	public static void morrisIn(BinaryNode root) {
		if (root == null) {
			return;
		}
		BinaryNode cur1 = root;
		BinaryNode cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			System.out.print(cur1.data + " ");
			cur1 = cur1.right;
		}
	}
	
	public static void morrisPost(BinaryNode root) {
		if (root == null) {
			return;
		}
		BinaryNode cur1 = root;
		BinaryNode cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
					printRightEdge(cur1.left);  // 逆序打印左子树的右边界
				}
			}
			cur1 = cur1.right;
		}
		printRightEdge(root);  // 最后逆序打整棵树的右边界
	}
	
	public static void printRightEdge(BinaryNode head) {
		BinaryNode tail = reverseRightEdge(head);
		BinaryNode cur = tail;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.right;
		}
		reverseRightEdge(tail);
	}
	
	public static BinaryNode reverseRightEdge(BinaryNode head) {
		BinaryNode prev = null;
		BinaryNode next = null;
		while (head != null) {
			next = head.right;
			head.right = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void main(String[] args) {
			BinaryNode root = new BinaryNode(5);
			root.left = new BinaryNode(3);
			root.right = new BinaryNode(8);
			root.left.left = new BinaryNode(2);
			root.left.right = new BinaryNode(4);
			root.left.left.left = new BinaryNode(1);
			root.right.left = new BinaryNode(7);
			root.right.left.left = new BinaryNode(6);
			root.right.right = new BinaryNode(10);
			root.right.right.left = new BinaryNode(9);
			root.right.right.right = new BinaryNode(11);
			
			prevOrderTraverseR(root);
			System.out.println();
			morrisPrev(root);
			System.out.println();
			inOrderTraverseR(root);
			System.out.println();
			morrisIn(root);
			System.out.println();
			postOrderTraverseR(root);
			System.out.println();
			morrisPost(root);
	}

}
