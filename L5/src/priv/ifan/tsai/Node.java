package priv.ifan.tsai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ifan Tsai (caiyifan) 图的节点描述
 */
public class Node {
	public int value; // 数据
	public int in; // 入度
	public int out; // 出度
	public List<Node> nextNodes; // 邻居节点集
	public List<Edge> edges; // 发出的边集

	public Node(int value) {
		this.value = value;
		nextNodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		in = 0;
		out = 0;
	}
}
