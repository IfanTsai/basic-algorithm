package _6;

import java.util.Scanner;

public class _5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		String[][] strs = new String[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				strs[i][j] = sc.next();
			}
		}
		
		double[][] res = new double[m][n];
		boolean[][] books = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!books[i][j]) {
					dfs(strs, books, res, i, j);
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%.2f ", res[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void dfs(String[][] strs, boolean[][] books, double[][] res, int i, int j) {
		if (strs[i][j].startsWith("SUM")) {
			int[] coos = split(strs[i][j]);
			res[i][j] = sum(strs, books, res, coos[0], coos[1], coos[2], coos[3]);
		} else if (strs[i][j].startsWith("AVG")) {
			int[] coos = split(strs[i][j]);
			res[i][j] = avg(strs, books, res, coos[0], coos[1], coos[2], coos[3]);
		} else if (strs[i][j].startsWith("STD")) {
			int[] coos = split(strs[i][j]);
			res[i][j] = std(strs, books, res, coos[0], coos[1], coos[2], coos[3]);
		} else {
			res[i][j] = Double.parseDouble(strs[i][j]);
		}
		books[i][j] = true;
	}
	
	
	public static int[] split(String str) {
		String[] coos = str.split("\\(")[1].split(":");
		int m1 = Integer.parseInt(coos[0].split(",")[0]);
		int n1 = Integer.parseInt(coos[0].split(",")[1]);
		int m2 = Integer.parseInt(coos[1].split(",")[0]);
		int n2 = Integer.parseInt(coos[1].split(",")[1].replace(")", ""));
		
		return new int[] { m1, n1, m2, n2 };
	}
	
	public static double sum(String[][] strs, boolean[][] books, double[][] res, int m1, int n1, int m2, int n2) {
		double ans = 0;
		for (int i = m1 - 1; i < m2; i++) {
			for (int j = n1 - 1; j < n2; j++) {
				if (!books[i][j]) {
					dfs(strs, books, res, i, j);
				}
				ans += res[i][j];
			}
		}
		return ans;
	}
	
	public static double avg(String[][] strs, boolean[][] books, double[][] res, int m1, int n1, int m2, int n2) {
		return sum(strs, books, res, m1, n1, m2, n2) / ( (m2 - m1 + 1) * (n2 - n1 + 1) );
	}
	
	public static double std(String[][] strs, boolean[][] books, double[][] res, int m1, int n1, int m2, int n2) {
		double avg = avg(strs, books, res, m1, n1, m2, n2);
		System.out.println("avg = " + avg);
		System.out.println("(" + m1 + "," + n1 + ")");
		System.out.println("(" + m2 + "," + n2 + ")");
		double ans = 0;
		for (int i = m1 - 1; i < m2; i++) {
			for (int j = n1 - 1; j < n2; j++) {
				ans += Math.pow(res[i][j] - avg, 2);
			}
		}
		
		return Math.sqrt(ans / ( (m2 - m1 + 1) * (n2 - n1 + 1)));
	}
		
}
