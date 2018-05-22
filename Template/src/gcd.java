
public class gcd {
	public static void main(String[] args) {
		System.out.println(gcd(15, 27));
	}
	
	public static int gcd1(int a, int b) {
		int c = a % b;
		while (c != 0) {
			a = b;
			b = c;
			c = a % b;
		}
		return b;
	}
	
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

}
