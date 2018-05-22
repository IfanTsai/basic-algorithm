package _5;

public class _1 {
	public static void main(String[] args) {
		for (int i = 12; true ;i++) {
			if (i % 4 != 0 || i % 5 != 0 || i % 6 != 0 || i % 7 != 0 || i % 8 != 0 ||  i % 9 != 0) continue;
			if (i - (i / 4 + i / 5 + i / 6 + i / 7 + i / 8 + i / 9) == 11) {
				System.out.println(i);
				break;
			}
		}
	}
}
