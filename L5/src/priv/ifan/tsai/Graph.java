package priv.ifan.tsai;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {

	/**
	 * 点集 key为编号,value为节点
	 */
	public HashMap<Integer, Node> nodes;
	/**
	 * 边集
	 */
	public HashSet<Edge> edges;

	public Graph() {
		nodes = new HashMap<Integer, Node>();
		edges = new HashSet<Edge>();
	}

	public static Graph generateGraph(int[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			int from = matrix[i][0]; // from节点编号
			int to = matrix[i][1]; // to节点编号
			int weight = matrix[i][2]; // from到to的权重
			/*
			 * graph中不包含from和to节点, 则创建
			 */
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			/*
			 * 取出from和to节点
			 */
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			/*
			 * 创建边
			 */
			Edge edge = new Edge(fromNode, toNode, weight);
			fromNode.nextNodes.add(toNode);
			fromNode.out++;
			toNode.in++;
			/*
			 * 将边加入graph的边集中
			 */
			graph.edges.add(edge);
			/*
			 * 将边加入from节点的边集中
			 */
			fromNode.edges.add(edge);
		}
		return graph;
	}
}
