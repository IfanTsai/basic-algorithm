package leetcode;

// 矩阵快速幂
public class QuickMatrixPower {
	public static int[][] quickMatrixPow(int[][] m, int n) {
		int[][] res = new int[m.length][m[0].length];
		for (int i = 0; i < m.length; i++) {
			res[i][i] = 1;
		}
		for ( ; n != 0; n >>= 1) {
			if ((n & 1) == 1) {
				res = matrixMuil(res, m);
			}
			m = matrixMuil(m, m);
		}
		return res;
	}
	
	public static int[][] matrixMuil(int[][] m1, int[][] m2) {
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] m = {{1, 1}, {1, 1}};
		int[][] res = quickMatrixPow(m, 3);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

}
