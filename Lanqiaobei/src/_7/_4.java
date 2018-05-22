package _7;

import java.util.Scanner;

public class _4 {
	
	static boolean[][] vis; 
	static int[] map;
	static int mapIndex = 0;
	static int[] sum = new int[2];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] nums = new int[2][n];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				nums[i][j] = sc.nextInt();
				sum[i] += nums[i][j];
			}
		}
		vis = new boolean[n][n];
		map = new int[n * n + 1];
		
		long s = System.currentTimeMillis();
		dfs(nums, 0, 0);
		long e = System.currentTimeMillis();
		System.out.println(e - s + "ms");
		
	}
		
	
	public static void dfs(int[][] nums, int x, int y) {
		if (x == nums[0].length - 1 && y == nums[0].length - 1) {
			map[mapIndex++] = x * nums[0].length + y;
			nums[0][y]--;
			nums[1][x]--;
			sum[0]--;
			sum[1]--;
			vis[x][y] = true;
			
			if (sum[0] == 0 && sum[1] == 0) {
				for (int i = 0; i < mapIndex; i++) {
					System.out.print(map[i] + " ");
				}
				System.out.println();
			}
			
			nums[0][y]++;
			nums[1][x]++;
			sum[0]++;
			sum[1]++;
			vis[x][y] = false;
			mapIndex--;
			return;
		}
		
		vis[x][y] = true;
		nums[0][y]--;
		nums[1][x]--;
		sum[0]--;
		sum[1]--;
		map[mapIndex++] = x * nums[0].length + y;
		
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				if (dx * dy  == 0) {
					if (x + dx >= nums[0].length || y + dy >= nums[0].length || 
							x + dx < 0 || y + dy < 0 || vis[x + dx][y + dy]
							   || nums[0][y + dy] == 0  || nums[1][x + dx] == 0)   
						continue;
					dfs(nums, x + dx, y + dy);
				}
			}
		}
		
		mapIndex--;
		nums[0][y]++;
		nums[1][x]++;
		sum[0]++;
		sum[1]++;
		vis[x][y] = false;
	}
	
}
