package _7;

import java.util.Scanner;

public class Main {
	static int[] row;// 保存北边靶子上的数目
	static int[] col; // 保存西边靶子的数目
	static int[][] vis; // 标记数组，标记迷宫的方格是否走过
	static int N;
	// 上下左右四个方向
	static int[][] location = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	// 转换成0--N^2-1的数组，输出要求
	static int[][] print;
	static int rowSum = 0;// 北边靶子的总数目
	static int colSum = 0;// 西边靶子的总数目
	static int[] map = null; // 满足要求的行走路径
	static int aLen = 1; // 可行路径的长度

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 初始化数据
		row = new int[N];
		col = new int[N];
		vis = new int[N][N];
		print = new int[N][N];
		map = new int[N * N + 1];
		int index = 0;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				print[i][j] = index++;
		// 输入数据
		for (int i = 0; i < N; ++i) {
			row[i] = sc.nextInt();
			rowSum += row[i];
		}
		for (int i = 0; i < N; ++i) {
			col[i] = sc.nextInt();
			colSum += col[i];
		}
		// 开始计算
		row[0]--;
		rowSum--;
		col[0]--;
		colSum--;
		vis[0][0] = 1;
		map[0] = 0;
		// 从0,0出发
		dfs(0, 0);
	}

	public static void dfs(int x, int y) {
		if (x == N - 1 && y == N - 1) {
			// 打印结果
			if (rowSum == 0 && colSum == 0) {
				for (int i = 0; i < aLen; ++i)
					System.out.print(map[i] + " ");
			}
		}
		for (int i = 0; i < 4; ++i) {
			int dx = x + location[i][0];
			int dy = y + location[i][1];
			// 1.没出界，2.行列上的靶子数目至少为1
			if (dx >= 0 && dx < N && dy >= 0 && dy < N && vis[dx][dy] == 0
					&& row[dy] > 0 && col[dx] > 0) {
				vis[dx][dy] = 1;
				row[dy]--;
				rowSum--;
				col[dx]--;
				colSum--;
				map[aLen++] = print[dx][dy];
				dfs(dx, dy);
				aLen--; // 走不通，直接将map数组的aLen--
				vis[dx][dy] = 0;
				row[dy]++;
				rowSum++;
				col[dx]++;
				colSum++;
			}
		}
	}
}
