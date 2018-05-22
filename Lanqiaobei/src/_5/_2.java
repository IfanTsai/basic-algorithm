package _5;

public class _2 {

	public static void main(String[] args) {
		int[] nums = new int[19];
		nums[0] = 15;
		nums[1] = 13;
		int val = 1;
		for (int i = 2; i < nums.length; i++) {
			if (val == 13 || val == 15) {
				val++;
				i--;
				continue;
			}
			nums[i] = val++;
		}
		int[] per = new int[nums.length];
		per[0] = 15;
		per[1] = 13;
		dfs(nums, per, new boolean[nums.length], 2);
	}
	
	public static void dfs(int[] nums, int[] per, boolean[] vis, int x) {
		if (x == 7 && ( per[0] + per[1] + per[2] != per[3] + per[4] + per[5] + per[6])) {
			return;
		}
		if (x == 8 && (per[0] + per[1] + per[2] != per[0] + per[3] + per[7])) {
			return;
		}
		if (x == 12 && (per[0] + per[1] + per[2] != per[7] + per[8] + per[9] + per[10] + per[11])) {
			return;
		}
		if (x == 13 && (per[0] + per[1] + per[2] != per[1] + per[4] + per[8] + per[12])) {
			return;
		}
		if (x == 16 && (per[0] + per[1] + per[2] != per[12] + per[13] + per[14] + per[15])) {
			return;
		}
		if (x == 17 && (per[0] + per[1] + per[2] != per[2] + per[5] + per[9] + per[13] + per[16])) {
			return;
		}
		if (x == 17 && (per[0] + per[1] + per[2] != per[7] + per[12] + per[16])) {
			return;
		}
		if (x == 18 && (per[0] + per[1] + per[2] != per[6] + per[10] + per[14] + per[17])) {
			return;
		}
		
		if (x == nums.length) {
			if (judeg(per)) {
				for (int k = 7; k <= 11; k++) {
					System.out.print(per[k] + " ");
				}
			}
			return;
		}
		
		for (int i = 2; i < nums.length; i++) {
			if (!vis[i]) {
				vis[i] = true;
				per[x] = nums[i];
				dfs(nums, per, vis, x + 1);
				vis[i] = false;
			}
		}
	}


	public static boolean judeg(int[] nums) {
		int sum = nums[0] + nums[1] + nums[2];
		if (nums[3] + nums[4] + nums[5] + nums[6] != sum)
			return false;
		if (nums[7] + nums[8] + nums[9] + nums[10] + nums[11] != sum)
			return false;
		if (nums[12] + nums[13] + nums[14] + nums[15] != sum)
			return false;
		if (nums[16] + nums[17] + nums[18] != sum)
			return false;

		if (nums[7] + nums[12] + nums[16] != sum)
			return false;
		if (nums[3] + nums[8] + nums[13] + nums[17] != sum)
			return false;
		if (nums[0] + nums[4] + nums[9] + nums[14] + nums[18] != sum)
			return false;
		if (nums[1] + nums[5] + nums[10] + nums[15] != sum)
			return false;
		if (nums[2] + nums[6] + nums[11] != sum)
			return false;

		if (nums[0] + nums[3] + nums[7] != sum)
			return false;
		if (nums[1] + nums[4] + nums[8] + nums[12] != sum)
			return false;
		if (nums[2] + nums[5] + nums[9] + nums[13] + nums[16] != sum)
			return false;
		if (nums[6] + nums[10] + nums[14] + nums[17] != sum)
			return false;
		if (nums[11] + nums[15] + nums[18] != sum)
			return false;
		return true;
	}
}
