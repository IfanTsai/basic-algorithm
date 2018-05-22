package _7;

public class _1 {
	public static void main(String[] args) {
		int A = 0;
		int B = 1000;
		int C = 0;
		boolean toRight = true;
		int count = 0;
		while (B - A > 1) {
			B -= 1;
			A += 1;
			if (toRight) {
				C += 5;
				if (C >= B) {
					count++;
					C = B;
					toRight = false;
				}
			} else {
				C -= 5;
				if (C <= A) {
					C = A;
					toRight = true;
				}
			}
		}
		System.out.println(count);
	}
}
