package leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class _297_Serialize_and_Deserialize_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		if (root == null) {
			return "#_";
		}
		return root.val + "_" + serialize(root.left) + serialize(root.right);
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		String[] vals = data.split("_");
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < vals.length; i++) {
			queue.add(vals[i]);
		}
		return process(queue);

	}
	
	public static TreeNode process(Queue<String> queue) {
		String val = queue.poll();
		if (val.equals("#")) {
			return null;
		}
		TreeNode head = new TreeNode(Integer.parseInt(val));
		head.left = process(queue);
		head.right = process(queue);
		return head;
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.right.left = new TreeNode(4);
		node.right.right = new TreeNode(5);
		System.out.println(serialize(node));
		
		deserialize("1_2_#_#_3_4_#_#_5_#_#_");
	}
	
}
