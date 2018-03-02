package priv.ifan.tsai;

import java.util.PriorityQueue;

/*
 * 题目:
 * 一块金条切成两半,是需要花费和长度数值一样的同班的.
 * 比如长度为20的金条,不管切成长度多大的两半,都要花费20个铜板.
 * 一群人想整分整块金条,怎么分最省铜板?
 * 
 * 例如,给定数组{10, 20, 30}, 代表一共三个人,整块金条长度为10 + 20 + 30 = 60.
 * 金条要分成10, 20, 30三个部分.
 * 如果,
 * 先把长度60的金条分成10和50, 花费60
 * 再把长度50的金条分成20和30, 花费50
 * 一共花费110铜板
 * 但是如果,
 * 先把长度60的金条分成30和30, 花费60
 * 再把长度30的金条分成10和20, 花费30
 * 一共花费90铜板
 * 
 * 输入一个数组, 返回分割的最小代价
 */
public class LessMoney {

	public static void main(String[] args) {
		int[] arr = new int[] {10, 20, 30};
		System.out.println(getLessMoney(arr));
	}

	// 哈夫曼编码问题
	// 将所有数放入一个小根堆,从小根堆取出两个数相加,相加后得到的数放回堆,反复执行这个过程
	// 直到堆里只剩下一个数结束,过程中的所有相加后得到的数累计就是最小的花费
	private static int getLessMoney(int[] arr) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}
		int res = 0;
		while (heap.size() != 1) {
			int curMoney = heap.poll() + heap.poll();
			res += curMoney;
			heap.add(curMoney);
		}
		return res;
	}
}
