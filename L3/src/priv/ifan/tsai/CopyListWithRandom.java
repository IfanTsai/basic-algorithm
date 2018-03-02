package priv.ifan.tsai;

import java.util.HashMap;

/*
 * 复制含有随机指针节点的链表
 * 
 * 题目: 
 * Node类中的value是节点值, next指针和正常单链表中next指针的意义一 样, 都指向下一个节点, 
 * rand指针是Node类中新增的指针, 这个指针可能指向链表中的任意一个节点, 也可能指向null
 * 给定一个由Node节点类型组成的无环单链表的头节点head, 
 * 请实现一个函数完成这个链表中所有结构的复制, 并返回复制的新链表的头节点
 * 
 * 进阶: 
 * 不使用额外的数据结构, 只用有限几个变量, 且在时间复杂度为O(N)内完成原问题要实现的函数
 */
public class CopyListWithRandom {

	public static void main(String[] args) {

	}

	static class Node {
		public int value;
		public Node next;
		public Node rand;
		public Node(int data) {
			this.value = data;
		}
	}
	
	// 普通: 借助哈希表将老结点和新结点的对应关系存起来,
	// 利用哈希表由老结点找到新节点,并按照老结点的连接方式设置到新节点
	@SuppressWarnings("unused")
	private static Node copyListWithRandom1(Node head) {
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		Node newNode;
		cur = head;
		while (cur != null) {
			newNode = map.get(cur);
			newNode.next = map.get(cur.next);
			newNode.rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}
	
	// 进阶: 不使用哈希表,将新节点塞到老结点,这样一来就可以通过老结点找到新节点,而无需使用哈希表来存
	// 设置好新节点的rand指针的连接方式,最后将两链表分离
	@SuppressWarnings("unused")
	private static Node copyListWithRandom2(Node head) {
		Node cur = head;
		Node next;
		// 插入新节点到老结点后面
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur = next;
		}
		
		cur = head;
		// 设置新节点的rand指针的连接方式
		while (cur != null) {
			cur.next.rand = cur.rand != null ? cur.rand.next : null;
			cur = cur.next.next;
		}
		
		Node res = head.next;
		// 分离两个链表
		cur = head;
		while (cur != null) {
			next = cur.next.next;
			cur.next.next = next != null ? next.next : null;
			cur.next = next;
			cur = next;
		}
		return res;
	}
}
