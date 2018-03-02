package priv.ifan.tsai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

	static class DisComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
	}

	public static List<Edge> prim(Graph graph) {
		PriorityQueue<Edge> distanceQueue = new PriorityQueue<Edge>(1,
				new DisComparator());
		Node startNode = graph.nodes.get(1);
		for (Edge edge : startNode.edges) {
			distanceQueue.add(edge);
		}
		HashSet<Node> nodeSet = new HashSet<Node>();
		nodeSet.add(startNode);
		List<Edge> res = new ArrayList<Edge>();
		while (!distanceQueue.isEmpty()) {
			Edge edge = distanceQueue.poll();
			Node toNode = edge.to;
			if (!nodeSet.contains(toNode)) {
				nodeSet.add(toNode);
				res.add(edge);
				for (Edge nextEdge : toNode.edges) {
					distanceQueue.add(nextEdge);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 4 }, { 2, 3, 8 }, { 3, 4, 7 }, { 4, 5, 9 },
				{ 5, 6, 10 }, { 6, 4, 14 }, { 6, 3, 4 }, { 6, 7, 2 },
				{ 7, 9, 6 }, { 7, 8, 1 }, { 9, 3, 2 },
				{ 9, 8, 7 },
				{ 8, 2, 11 },
				{ 8, 1, 8 },
				// 无向带权图
				{ 2, 1, 4 }, { 3, 2, 8 }, { 4, 3, 7 }, { 5, 4, 9 },
				{ 6, 5, 10 }, { 4, 6, 14 }, { 3, 6, 4 }, { 7, 6, 2 },
				{ 9, 7, 6 }, { 8, 7, 1 }, { 3, 9, 2 }, { 8, 9, 7 },
				{ 2, 8, 11 }, { 1, 8, 8 }, };
		Graph graph = Graph.generateGraph(matrix);
		List<Edge> edges = prim(graph);
		int sum = 0;
		for (Edge edge : edges) {
			System.out.print(edge.weight + " ");
			sum += edge.weight;
		}
		System.out.println("\n" + "cost is " + sum);
	}
}
