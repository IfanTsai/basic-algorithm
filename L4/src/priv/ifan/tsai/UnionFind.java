package priv.ifan.tsai;

import java.util.HashMap;
import java.util.List;


/**
 * @author Ifan Tsai (caiyifan)
 * @time 2018年2月19日21:41:49
 * 并查集
 * find()   查询
 * union()  合并
 */

public class UnionFind {
	
	// 并查集的数据
	class Node {
		
	}
	
	/*
	 * 各节点的父节点(即该集合的代表节点)   注: 父节点指向自身, 而不是指向null
 	 */
	private HashMap<Node, Node> fatherMap; 
	/*
	 * 各父节点所在集合的大小    注: 该表中非父节点的数据无效
	 */
	private HashMap<Node, Integer> rankMap;  
	
	public UnionFind(List<Node> head) {
		fatherMap = new HashMap<Node, Node>();
		rankMap = new HashMap<Node, Integer>();
		/*
		 * 初始化时, 各节点自成一个集合, 本身即为该集合的父节点而指向自身
		 */
		for (Node node : head) {
			fatherMap.put(node, node);
			rankMap.put(node, 1);
		}
	}
	
	/*
	 * 查找父节点, 返回父节点. 每次调用后该节点到父节点的路径会被压缩
	 */
	public Node find(Node n) {
		Node father = fatherMap.get(n);
		if (father != n) {
			father = find(father);
		}
		fatherMap.put(n, father);
		return father;
	}
	
	/*
	 * 合并两个节点所在的集合(将rank小的集合挂在大的父节点下面)
	 */
	public void union(Node a, Node b) {
		if (a == null || b == null) {
			return;
		}
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
