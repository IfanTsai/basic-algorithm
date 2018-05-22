

/*
 * 题目:
 * 给定一个数,判断该数是否为回文数
 */
public class IsPalindrome {
	public static void main(String[] args) {
		int num = 12321;
		System.out.println(isPalindrome(num));
	}
	
	public static boolean isPalindrome(int num) {
		int help = 1;
		// 如果num为12321, 则将help设置为10000
//		while (help * 10 <= num) {      // 可能会产生溢出,导致死循环
//			help *= 10;
//		} 
		while (num / help >= 10) {      // 所以将乘法转为除法
			help *= 10;
		}
		while (num != 0) {
			// 比较num最高位的数和最低位的数是否相等
			if (num / help != num % 10) {
				return false;
			}
			// 把num最高位和最低位的数给剥掉
			num = num % help / 10;
			// help减少两位
			help /= 100;
		}
		return true;
	}
	
	
}
