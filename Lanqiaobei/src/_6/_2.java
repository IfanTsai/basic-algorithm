package _6;

public class _2 {
	static int count = 0;
	
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 };
		permutation(nums, 0);
		System.out.println(count / 10);
	}
	
	public static void permutation(int[] nums, int i) {
		if (i == nums.length) {
			int res1 = nums[0] + nums[2] + nums[5] + nums[8];
			int res2 = nums[1] + nums[2] + nums[3] + nums[4];
			int res3 = nums[0] + nums[3] + nums[6] + nums[9];
			int res4 = nums[1] + nums[5] + nums[7] + nums[9];
			int res5 = nums[4] + nums[6] + nums[7] + nums[8];
			if (res1 == res2 && res2 == res3 && res3 == res4 && res4 == res5) {
				count++;
				for (int num : nums) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		}
		for (int j = i; j < nums.length; j++) {
			swap(nums, i, j);
			permutation(nums, i + 1);
			swap(nums, i, j);
		}
	}
	
	public static void swap(int[] nums, int i, int j) {
		if (nums[i] != nums[j]) {
			nums[i] ^= nums[j];
			nums[j] ^= nums[i];
			nums[i] ^= nums[j];
		}
	}
}
