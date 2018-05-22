package _4;

public class _1 {
	public static void main(String[] args) {
		for (int a = 0; a <= 9; a++) {
			for (int b = 0; b <= 9; b++) {
				for (int c = 0; c <= 9; c++) {
					for (int d = 0; d <= 9; d++) {
						for (int e = 0; e <= 9; e++) {
							for (int f = 0; f <= 9; f++) {
								if (a == b || a == c || a == d || a == e || a == f) continue;
								if (b == c || b == d || b == e || b == f) continue;
								if (c == d || c == e || c == f) continue;
								if (d == e || d == f) continue;
								
								int num1 = a * 100 + b * 10 + c ;
								int num2 = a * 100000 + d * 10000 + e * 1000 + f * 100 + d * 10 + b;
								if (num1 * num1 == num2) {
									System.out.println(num1);
								}
							}
						}
					}
				}
			}
		}
	}
}
