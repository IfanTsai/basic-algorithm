package _6;

import java.util.Scanner;

public class _4 {
	public static void main(String[] args) {
		int x = -1, y = -1;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] chs = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chs[i][j] = sc.next().charAt(0);
				if (chs[i][j] == 'A') {
					x = i;  y = j;
				}
			}
		}
		
		System.out.println(dfs(chs, x, y));
		
	}
	
	public static int dfs(char[][] chs, int i, int j) {
	    if (chs[i][j] == 'B')  return 0;
		
		char last = chs[i][j];
		chs[i][j] = 0;
		
		int res = Integer.MAX_VALUE;
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				if (x == y || i + x < 0 || i + x >= chs.length || x * y == -1 ||
						j + y < 0 || j + y >= chs[0].length || chs[i + x][j + y] == last || chs[i + x][j + y] == 0) 
					continue;
				res = Math.min(res, dfs(chs, i + x, j + y));
			}
		}
		
		chs[i][j] = last;
		return res == Integer.MAX_VALUE ? res : res + 1;
	}
	
	public static int f(char[][] data, int x, int y)
	{
		if (data[x][y] == 'B') return 0;   // base case

		char old = data[x][y];
		data[x][y] = 0;        // 标记为0表示访问过了

		int m = Integer.MAX_VALUE;

		if (x > 0 && data[x - 1][y] != 0 && data[x - 1][y] != old)
            m = Math.min(m, f(data, x - 1, y));

		if (x < data.length - 1 && data[x + 1][y] != 0 && data[x + 1][y] != old)
            m = Math.min(m, f(data, x + 1, y));

		if (y < data.length - 1 && data[x][y + 1] != 0 && data[x][y + 1] != old)
            m = Math.min(m, f(data, x, y+1));

		if (y > 0 && data[x][y - 1] != 0 && data[x][y - 1] != old)
            m = Math.min(m, f(data, x, y - 1));

		data[x][y] = old;       // 回溯

		return m == Integer.MAX_VALUE ? m : m + 1;
	}
}
