package _5;

import java.math.BigInteger;
import java.util.Scanner;

public class _5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n + 1];
		for (int i = 1; i < m.length; i++) {
			int x = sc.nextInt();
		    int y = sc.nextInt();
		    m[x] = y;
		}
		
		BigInteger max = new BigInteger("1");
		boolean[] vis = new boolean[m.length];
		for (int i = 1; i < m.length; i++) {
			if (vis[i])  continue;
			BigInteger count = new BigInteger("1");
			int s = i;
			vis[s] = true;
			
			while (m[s] != i) {
				count = count.add(new BigInteger("1"));
				s = m[s];
				vis[s] = true;
			}
			
			max = max.multiply(count).divide(gcd(max, count));
		}
		
		System.out.println(max);
	}
	
	
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		return b.compareTo(BigInteger.ZERO) == 0 ? a : gcd(b, a.mod(b));
	}
	
}
