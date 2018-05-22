package _6;

import java.util.Vector;

public class _1 {

	static int count = 0;
	
	public static void main(String[] args) {
		int[] nums = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		comb(nums, new Vector<Integer>(), 0, nums.length, 3);
		System.out.println("total: " + count);
	}
	
	
	// 求nums中从start到end的size个数的组合
    public static void comb(int[] nums, Vector<Integer> vc, int start, int end, int size) {
		if (size == 0) {
			for (Integer i : vc) {
				System.out.print(i);
			}
			System.out.println();
			count++;
			return;
		}
		if (start >= end) return;
		vc.add(nums[start]);
		comb(nums, vc, start + 1, end, size - 1);
		vc.remove(vc.size() - 1);
		comb(nums, vc, start + 1, end, size);
	}
}
