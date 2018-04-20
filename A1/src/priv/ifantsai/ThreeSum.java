package priv.ifantsai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> list = threeSum(nums);
		for (List<Integer> ints : list) {
			for (Integer i : ints) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0) {
				while (i + 1 < nums.length && nums[i] == nums[i - 1]) {
					i++;
				}
			}
			int target = 0 - nums[i];
			int p1 = i + 1, p2 = nums.length - 1;
			while (p1 < p2) {
				if (nums[p1] + nums[p2] > target) {
					p2--;
				} else if (nums[p1] + nums[p2] < target) {
					p1++;
				} else {
					List<Integer> l = new ArrayList<Integer>();
					l.add(nums[i]);
					l.add(nums[p1]);
					l.add(nums[p2]);
					list.add(l);
					int t = nums[p1++];
					while (p1 < p2 && nums[p1] == t) {
						p1++;
					}
				}
			}
		}
		return list;
    }
}
