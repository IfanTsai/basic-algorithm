package priv.ifan.tsai;

public class KMP {

	public static int kmp(String str1, String str2) {
		if (str1 == null || str2 == null || str2.length() < 1 || str1.length() < str2.length()) {
			return -1;
		}
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int i = 0;
		int j = 0;
		int[] next = getNextArray(s2);
		while (i < s1.length && j < s2.length) {
			if (s1[i] == s2[j]) {
				i++;
				j++;
			} else if (next[j] == -1) {
				i++;
			} else {
				j = next[j];
			}
		}
		return j == s2.length ? i - j : -1;
	}
	
	public static int[] getNextArray(char[] str) {
		if (str.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[str.length];
		next[0] = -1;
		next[1] = 0;
		int i = 2;
		int cn = 0;
		while (i < next.length) {
			if (str[i - 1] == str[cn]) {
				next[i++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[i++] = 0;
			}
		}
		return next;
	}
	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(kmp(str, match));
	}

}
