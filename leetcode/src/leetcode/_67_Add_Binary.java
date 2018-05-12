package leetcode;

import java.util.Stack;

public class _67_Add_Binary {
	public static String addBinary(String a, String b) {
        Stack<Character> stack = new Stack<Character>();
		int i = a.length() - 1, j = b.length() - 1;
		int co = 0;
		while (i >= 0 && j >= 0) {
			stack.push((char) ( (a.charAt(i) - '0') ^ (b.charAt(j) - '0') ^ co + '0'));
			co =  ((a.charAt(i) - '0') & (b.charAt(j) - '0')) | co & ((a.charAt(i) - '0') ^ (b.charAt(j) - '0'));
			i--; j--;
		}
		while (i >= 0) {
			stack.push((char) (a.charAt(i) ^ co));
			co = co & (a.charAt(i--) - '0');
		}
		while (j >= 0) {
			stack.push((char) (b.charAt(j) ^ co));
			co = co & (b.charAt(j--) - '0'); 
		}
		if (co == 1) {
			stack.push('1');
		}
		char[] res = new char[stack.size()];
		for (int k = 0; k < res.length; k++) {
			res[k] = stack.pop();
		}
		return String.valueOf(res);
    }
}
