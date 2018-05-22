package _8;
import java.math.BigInteger;
import java.util.HashSet;

public class _1 {
	public static void main(String[] args) {
		BigInteger lo = new BigInteger("32043");
		BigInteger hi = new BigInteger("100000");
		BigInteger res;
		while (hi.compareTo(lo) >= 0) {
			res = hi.multiply(hi);
			if (check(res)) {
				System.out.println(res);
				break;
			}
			hi = hi.subtract(new BigInteger("1"));
		}
	}
	
	public static boolean check(BigInteger num) {
		String str = num.toString();
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}
		if (set.size() == 10) {
			return true;
		} 
		return false;
	}
}
