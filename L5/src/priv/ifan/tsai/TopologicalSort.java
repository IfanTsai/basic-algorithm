package priv.ifan.tsai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
	public List<Node> topologicalSort(Graph graph) {
		HashMap<Node, Integer> inMap = new HashMap<Node, Integer>();
		Queue<Node> zeroInQueue = new LinkedList<Node>();
		for (Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroInQueue.add(node);
			}
		}

		List<Node> res = new ArrayList<Node>();
		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			res.add(cur);
			for (Node node : cur.nextNodes) {
				inMap.put(node, inMap.get(node) - 1);
				if (inMap.get(node) == 0) {
					zeroInQueue.add(node);
				}
			}
		}

		return res;
	}
}
