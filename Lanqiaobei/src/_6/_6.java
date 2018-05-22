package _6;

import java.util.Scanner;

public class _6 {
	static int[][][] zhuan = {
				{ { 1, 0 }, { 1, 1 } }, 
				{ { 1, 1 }, { 1, 0 } },
				{ { 1, 1 }, { 0, 1 } }, 
				{ { 0, 1 }, { 1, 1 } },
				{ { 1, 0 }, { 1, 1 }, { 1, 0 } },
				{ { 1, 1, 1 }, { 0, 1, 0 } },
				{ { 0, 1 }, { 1, 1 }, { 0, 1 } }, 
				{ { 0, 1, 0 }, { 1, 1, 1 } }, 
			};
	static int n;
	static int m;
	static int sum = 0;

	static void paiXu(int i, int x, int y, int[][] di) {
		if (y == n)
			return;
		if (x == m - 1 && y == n - 1 && di[y][x] == 1) {
			sum++;
			return;
		}
		for (; i < zhuan.length; i++) {
			if (panDuan(i, x, y, di)) {
				int[][] newdi = cha(i, x, y, di);
				if (newdi[y][x] == 1) {
					if (x == m - 1)
						paiXu(0, 0, y + 1, newdi);
					else
						paiXu(0, x + 1, y, newdi);
				}
			}
			if (i == 0 && di[y][x] == 1) {
				int newdi[][] = newdi(di);
				if (x == m - 1)
					paiXu(0, 0, y + 1, newdi);
				else
					paiXu(0, x + 1, y, newdi);
			}
		}
	}

	static int[][] newdi(int[][] di) {
		int[][] newdi = new int[n][m];
		for (int p = 0; p < n; p++)
			for (int q = 0; q < m; q++)
				newdi[p][q] = di[p][q];
		return newdi;
	}

	static boolean panDuan(int i, int x, int y, int[][] di) {
		if (x + zhuan[i][0].length > m)
			return false;
		if (y + zhuan[i].length > n)
			return false;
		for (int i0 = y, iz = 0; iz < zhuan[i].length; i0++, iz++)
			for (int j0 = x, jz = 0; jz < zhuan[i][iz].length; j0++, jz++) {
				if (di[i0][j0] == 1 && zhuan[i][iz][jz] == 1)
					return false;
			}
		return true;
	}

	static int[][] cha(int i, int x, int y, int[][] di) {
		int[][] newdi = newdi(di);
		for (int i0 = y, iz = 0; iz < zhuan[i].length; i0++, iz++)
			for (int j0 = x, jz = 0; jz < zhuan[i][iz].length; j0++, jz++) {
				if (di[i0][j0] == 0 && zhuan[i][iz][jz] == 1) {
					newdi[i0][j0] = 1;
				}
			}
		return newdi;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		int[][] di = new int[n][m];
		paiXu(0, 0, 0, di);
		System.out.println(sum);
	}
}
