package priv.ifantsai;

public class UglyNumer {
	public static void main(String[] args) {
		getUglyNum1(100);
		System.out.println();
		getUglyNum2(100);
	}
	
	public static boolean isUglyNum(int num) {
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		return num == 1;
	}
	
	public static void getUglyNum1(int n) {
		int num = 1;
		int count = 0;
		while (count < n) {
			if (isUglyNum(num)) {
				count++;
				System.out.print(num + " ");
			}
			num++;
		}
	}
	
	public static void getUglyNum2(int n) {
		int[] help = new int[n];
		help[0] = 1;
		int x2 = 0, x3 = 0, x5 = 0;
		for (int i = 1; i < n; i++) {
			help[i] = Math.min(Math.min(help[x2] * 2, help[x3] * 3), help[x5] * 5);
			if (help[i] == help[x2] * 2) {
				x2++;
			} else if (help[i] == help[x3] * 3) {
				x3++;
			} else if (help[i] == help[x5] * 5) {
				x5++;
			}
			if (help[i] == help[i - 1]) {
				i--;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(help[i] + " ");
		}
		
	}
}
