package priv.ifan.tsai;

/**
 * @author Ifan Tsai (caiyifan) 图的边描述
 */
public class Edge {
	public Node from; // from节点
	public Node to; // to节点
	public int weight; // 权重

	public Edge(Node from, Node to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}
