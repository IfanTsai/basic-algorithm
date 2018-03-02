package priv.ifan.tsai;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DfsBfs {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 1 }, { 1, 3, 1 }, { 3, 6, 1 },
				{ 3, 7, 1 }, { 7, 5, 1 }, { 4, 5, 1 }, { 2, 4, 1 } };
		Graph graph = Graph.generateGraph(matrix);
		Node node = graph.nodes.get(1);
		dfs(node);
		System.out.println();
		dfsR(node);
		System.out.println();
		bfs(node);
	}

	/*
	 * note: dfs: push就打印 bfs: poll就打印 而set都是为了防止重复push和add
	 */

	public static void dfs(Node n) {
		Stack<Node> stack = new Stack<Node>();
		HashSet<Node> set = new HashSet<Node>();
		System.out.print(n.value + " ");
		stack.push(n);
		set.add(n);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node node : cur.nextNodes) {
				if (!set.contains(node)) {
					System.out.print(node.value + " ");
					set.add(node);
					stack.push(cur);
					stack.push(node);
					break;
				}
			}
		}
	}

	static HashSet<Node> set = new HashSet<Node>();

	public static void dfsR(Node n) {
		System.out.print(n.value + " ");
		set.add(n);
		for (Node node : n.nextNodes) {
			if (!set.contains(node)) {
				dfsR(node);
			}
		}
	}

	public static void bfs(Node n) {
		Queue<Node> queue = new LinkedList<Node>();
		HashSet<Node> set = new HashSet<Node>();
		queue.add(n);
		while (!queue.isEmpty()) {
			n = queue.poll();
			System.out.print(n.value + " ");
			for (Node node : n.nextNodes) {
				if (!set.contains(node)) {
					queue.add(node);
					set.add(node);
				}
			}
		}
	}
}
