package leetcode;

import java.util.Stack;



public class _66_Plue_One {
	public static int[] plusOne(int[] digits) {
		Stack<Integer> stack = new Stack<Integer>();
		int co = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (i == digits.length - 1) {
				co = (digits[i] + 1) >= 10 ? 1 : 0;
				stack.push((digits[i] + 1) % 10);
			} else {
				stack.push((digits[i] + co) % 10);
				co = (digits[i] + co) >= 10 ? 1 : 0; 
			}
		}
		if (co == 1) {
			stack.push(1);
		}
		int[] res = new int[stack.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = stack.pop();
		}
		return res;
    }
	
	public static void main(String[] args) {

		int[] nums = {8,9,9,9};
		int[] res = plusOne(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		
	}
}
