package priv.ifan.tsai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {

	static class UnionFind {
		HashMap<Node, Node> fatherMap;
		HashMap<Node, Integer> rankMap;

		public UnionFind(Collection<Node> collection) {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
			for (Node node : collection) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}

		public Node find(Node n) {
			Node father = fatherMap.get(n);
			if (n != father) {
				father = find(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public void union(Node a, Node b) {
			Node aFather = find(a);
			Node bFather = find(b);
			if (aFather != bFather) {
				int aRank = rankMap.get(aFather);
				int bRank = rankMap.get(bFather);
				if (aRank <= bRank) {
					fatherMap.put(aFather, bFather);
					rankMap.put(bFather, aRank + bRank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aRank + bRank);
				}
			}
		}
	}

	static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
	}

	public static List<Edge> kruskal(Graph graph) {
		UnionFind unionFind = new UnionFind(graph.nodes.values());
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(1,
				new EdgeComparator());
		for (Edge edge : graph.edges) {
			queue.add(edge);
		}
		List<Edge> res = new ArrayList<Edge>();
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (unionFind.find(edge.from) != unionFind.find(edge.to)) {
				unionFind.union(edge.from, edge.to);
				res.add(edge);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 4 }, { 2, 3, 8 }, { 3, 4, 7 }, { 4, 5, 9 },
				{ 5, 6, 10 }, { 6, 4, 14 }, { 6, 3, 4 }, { 6, 7, 2 },
				{ 7, 9, 6 }, { 7, 8, 1 }, { 9, 3, 2 }, { 9, 8, 7 },
				{ 8, 2, 11 }, { 8, 1, 8 }, };
		Graph graph = Graph.generateGraph(matrix);
		List<Edge> edges = kruskal(graph);
		int sum = 0;
		for (Edge edge : edges) {
			System.out.print(edge.weight + " ");
			sum += edge.weight;
		}
		System.out.println("\n" + "cost is " + sum);
	}

}
