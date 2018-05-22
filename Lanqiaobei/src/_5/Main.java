package _5;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// 创建索引数组num[n]
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			// 输入数组，注意要-1，因为题目说输入的行和列都是以1开始
			num[in.nextInt() - 1] = in.nextInt() - 1;
		}
		// 这里vis数组为了加快循环
		boolean[] vis = new boolean[n];
		// max存储最终结果
		BigInteger max = new BigInteger("1");
		// 从原数组的第0行开始，寻找搜索
		for (int i = 0; i < n; i++) {
			// 如果当前行已经被搜索过，直接continue
			if (vis[i]) {
				continue;
			}
			// count记录搜索次数
			BigInteger count = new BigInteger("1");
			// s为每次搜索的数组下标索引
			int s = i;
			// 当前第s行被搜索了，记录vis数组
			vis[s] = true;
			// 当索引与值不相等时就继续循环
			while (num[s] != i) {
				// 每次循环一次count+1
				count = count.add(new BigInteger("1"));
				// 当前索引对应的值是下一次的索引
				s = num[s];
				// 当前索引对应的行被搜索过，记录vis数组
				vis[s] = true;
			}
			// 搜索结束，判断搜索结果是否能被max整除     求最小公倍数
			if (max.mod(count) != BigInteger.ZERO) {
				if (max.compareTo(count) > 0) {
					max = max.multiply(count).divide(gcd(count, max));
				} else {
					max = max.multiply(count).divide(gcd(max, count));
				}
			}
		}
		// 输出最终结果
		System.out.println(max);
	}

	// 辗转相除法
	public static BigInteger gcd(BigInteger max, BigInteger count) {
		return count.compareTo(BigInteger.ZERO) == 0 ? max : gcd(count, max.mod(count));
	}
}
