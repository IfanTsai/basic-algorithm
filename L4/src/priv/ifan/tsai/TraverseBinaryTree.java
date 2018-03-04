package priv.ifan.tsai;

import java.util.Stack;

public class TraverseBinaryTree {
	
	static class BinaryNode {
		public int data;
		public BinaryNode left;
		public BinaryNode right;
		
		public BinaryNode(int data) {
			this.data = data;
		}
	}
	
	// 先序遍历 递归实现
	private static void prevOrderTraverseR(BinaryNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			prevOrderTraverseR(root.left);
			prevOrderTraverseR(root.right);
		}
	}
	
	// 中序遍历 递归实现
	private static void inOrderTraverseR(BinaryNode root) {
		if (root != null) {
			inOrderTraverseR(root.left); 
			System.out.print(root.data + " ");
			inOrderTraverseR(root.right);
		}
	}
	
	// 后序遍历 递归实现
	private static void postOrderTraverseR(BinaryNode root) {
		if (root != null) {
			postOrderTraverseR(root.left);
			postOrderTraverseR(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	// 先序遍历 非递归实现
	private static void prevOrderTraverse(BinaryNode root) {
//		if (root != null) {
//			Stack<BinaryNode> stack = new Stack<BinaryNode>();
//			stack.push(root);
//			while (!stack.isEmpty()) {
//				root = stack.pop();
//				System.out.print(root.data + " ");
//				if (root.right != null) {
//					stack.push(root.right);
//				}
//				if (root.left != null) {
//					stack.push(root.left);
//				}
//			}
//		}
		if (root != null) {
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			while (!stack.isEmpty() || root != null) {
				if (root != null) {
					stack.push(root);
					System.out.print(root.data + " ");
					root = root.left;
				} else {
					root = stack.pop();
					root = root.right;
				}
			}
		}
	}
	
	// 中序遍历非递归实现
	private static void inOrderTraverse(BinaryNode root) {
		if (root != null) {
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			while (!stack.isEmpty() || root != null) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					System.out.print(root.data + " ");
					root = root.right;
				}
			}
		}
	}
	
	/*
	 * 思路: 改写先序遍历的过程,
	 *      将先序遍历中的左右次序调换形成中右左, 
	 *      然后将先序中stack的pop后打印改成pop后push到另一个辅助栈中,
	 *      最后执行完中右左的遍历后, 将辅助栈中的数依次pop, 次序就为中右左的逆序左右中, 即为后序遍历    
	 */
	// 后序遍历  非递归实现
	private static void postOrderTraverse(BinaryNode root) {	
		if (root != null) {
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			Stack<BinaryNode> helpStack = new Stack<BinaryNode>();
			stack.push(root);
			while (!stack.isEmpty()) {
				root = stack.pop();
				helpStack.push(root);
				if (root.left != null) {
					stack.push(root.left);
				} 
				if (root.right != null) {
					stack.push(root.right);
				}
			}
			
			while (!helpStack.isEmpty()) {
				System.out.print(helpStack.pop().data + " ");
			}
			
		}
		
		
		
		
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
		prevOrderTraverse(root);
		System.out.println();
		inOrderTraverseR(root);
		System.out.println();
		inOrderTraverse(root);
		System.out.println();
		postOrderTraverseR(root);
		System.out.println();
		postOrderTraverse(root);
	}

}
