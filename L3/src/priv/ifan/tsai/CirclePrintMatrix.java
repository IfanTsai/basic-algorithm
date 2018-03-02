package priv.ifan.tsai;

/*
 * 转圈打印矩阵
 * 
 * 题目:
 * 给定一个整数型矩阵matrix,请按照转圈的方式打印它.
 * 例如:
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 打印结果为1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
 * 
 * 要求:
 * 额外空间复杂度为O(1)
 */
public class CirclePrintMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };
		circlePrintMatrixR(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
		System.out.println();
		circlePrintMatrixR(matrix);
	}

	// 递归版本
	private static void circlePrintMatrixR(int[][] matrix, int r1, int c1, int r2, int c2) {
		/*
		 * 先以左上角和右下角作为边界打印最外圈,然后再以内圈的左上角和右下角作为边界打印,直到打印完
		 */
		if (r1 > r2 && c1 > c2) {
			return;
		}
		for (int i = c1; i < c2; i++) {
			System.out.print(matrix[r1][i] + " ");
		}
		for (int i = r1; i < r2; i++) {
			System.out.print(matrix[i][c2] + " ");
		}
		for (int i = c2; i > c1; i--) {
			System.out.print(matrix[r2][i] + " ");
		}
		for (int i = r2; i > r1; i--) {
			System.out.print(matrix[i][c1] + " ");
		}
		circlePrintMatrixR(matrix, r1 + 1, c1 + 1, r2 - 1, c2 - 1);
	}
	
	// 非递归版本
	private static void circlePrintMatrixR(int[][] matrix) {
		int r1 = 0, c1 = 0;
		int r2 = matrix.length - 1, c2 = matrix[0].length - 1;
		while (r1 < r2 && c1 < c2) {
			for (int i = c1; i < c2; i++) {
				System.out.print(matrix[r1][i] + " ");
			}
			for (int i = r1; i < r2; i++) {
				System.out.print(matrix[i][c2] + " ");
			}
			for (int i = c2; i > c1; i--) {
				System.out.print(matrix[r2][i] + " ");
			}
			for (int i = r2; i > r1; i--) {
				System.out.print(matrix[i][c1] + " ");
			}
			r1++;
			c1++;
			r2--;
			c2--;
		}
	
	}
}
