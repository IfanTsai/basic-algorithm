package priv.ifan.tsai;

/*
 * "之"字形打印矩阵
 * 
 * 题目:
 * 给定一个矩阵matrix,按照"之"字形的方式打印这个矩阵,例如:
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * "之"字形打印的结果为:1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12
 * 
 * 要求:
 * 额外空间复杂度为O(1)
 */
public class ZhiPrintMatrix {

	public static void main(String[] args) {
		int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} };
		zhiPrintMatrix(matrix);
	}
	
	private static void zhiPrintMatrix(int[][] matrix) {
		int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
		boolean toUp = true;
		while (r1 < matrix.length) {
			printLine(matrix, r1, c1, r2, c2, toUp);
			if (c1 == matrix[0].length - 1) {
				r1++;
			} else {
				c1++;
			}
			if (r2 == matrix.length - 1) {
				c2++;
			} else {
				r2++;
			}
			toUp = !toUp;
		}
	}
	
	private static void printLine(int[][] matrix, int r1, int c1, int r2, int c2, boolean toUp) {
		if (toUp) {
			while (r2 >= r1) {
				System.out.print(matrix[r2--][c2++] + " ");
			}
		} else {
			while (r1 <= r2) {
				System.out.print(matrix[r1++][c1--] + " ");
			}
		}
	}

}
