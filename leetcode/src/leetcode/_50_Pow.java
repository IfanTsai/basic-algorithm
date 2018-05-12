package leetcode;

public class _50_Pow {
	public static double myPow(double x, int n) {
		if (x == 1) {
			return 1;
		} else if (x == -1) {
			return n % 2 == 0 ? 1 : -1;
		} else if (n == Integer.MIN_VALUE) {
			return 0;
		}
        if (n < 0) {
        	x = 1 / x;
        	n = -n;
        }
        double res = 1.0;
        for ( ; n != 0; n >>= 1) {
        	if ((n & 1) == 1) {
        		res *= x;
        	}
        	x *= x;
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(myPow(2.10000, 3));
	}
}
