package _4;

public class _2 {
	public static void main(String[] args) {
		int aim = 111 * 111 * 111;
		int sum = 0;
		for (int i = 1; i < 1000000; i += 2) {
			sum = 0;
			for (int j = i; j < 10000; j += 2) {
				sum += j;
				if (sum > aim) break;
				if (sum == aim) {
					System.out.println(i);
				}
			}
		}
	}
}
