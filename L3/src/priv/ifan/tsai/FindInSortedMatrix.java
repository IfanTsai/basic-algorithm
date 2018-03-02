package priv.ifan.tsai;

/*
 * 在行列都排好序的矩阵中找数
 * 
 * 题目:
 * 给定一个有N*M的整型矩阵matrix和一个整数k,matrix的每一行和每一列都是排好序的.
 * 实现一个函数,判断k是否在matrix中
 * 例如:
 * 0  1  2  5
 * 2  3  4  7
 * 4  4  4  8
 * 5  7  7  9
 * 如果k为7,返回true;如果k为6返回false
 * 
 * 要求:
 * 时间复杂度为O(N+M),额外空间复杂度为O(1)
 */
public class FindInSortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = { {0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8}, {5, 7, 7, 9}};
		System.out.println(inSortedMatrix(matrix, 7));
		System.out.println(inSortedMatrix(matrix, 6));
	}
	
	private static boolean inSortedMatrix(int[][] matrix, int num) {
		// 从矩阵右上角开始扫描,如果num大了往下,小了往左
		int r = matrix[0].length - 1;
		int c = matrix[0].length - 1;
		while (r > 0 && c > 0 && r < matrix.length && c < matrix[0].length) {
			if (num < matrix[r][c]) {
				c--;
			} else if (num > matrix[r][c]) {
				r++;
			} else {
				return true;
			}
		}
		return false;
	}

}
