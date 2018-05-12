package leetcode;

import java.util.Stack;

public class _415_Add_Strings {

	public static String addStrings(String num1, String num2) {
		Stack<Character> stack = new Stack<Character>();
		int co = 0;
		int i = num1.length() - 1, j = num2.length() - 1;
		int t = 0;
		while (i >= 0 && j >= 0) {
			t = (num1.charAt(i--) - '0') + (num2.charAt(j--) - '0') + co;
			co = t >= 10 ? 1 : 0;
			t = t >= 10 ? t % 10 : t;
			stack.push((char) (t + '0'));
		}
		while (i >= 0) {
			t = (num1.charAt(i--) - '0') + co;
			co = t >= 10 ? 1 : 0; 
			t = t >= 10 ? t % 10 : t;
			stack.push((char) (t + '0'));
		}
		while (j >= 0) {
			t = (num2.charAt(j--) - '0') + co;
			co = t >= 10 ? 1 : 0; 
			t = t >= 10 ? t % 10 : t;
			stack.push((char) (t + '0'));
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

	public static void main(String[] args) {
		System.out.println(addStrings("49", "9"));
	}
}
