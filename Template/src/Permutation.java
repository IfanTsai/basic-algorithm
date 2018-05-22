import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class Permutation {
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		long startTime = System.currentTimeMillis();   //获取开始时间
		permutation(nums, 1);
		long endTime = System.currentTimeMillis(); //获取结束时间
		System.out.println("dfs permutation 程序运行时间： "+(endTime - startTime)+"ms");
		
		startTime = System.currentTimeMillis();
		permutation(nums, new int[nums.length], new boolean[nums.length], 1);
		endTime = System.currentTimeMillis();
		System.out.println("swap permuatation 程序运行时间： "+(endTime - startTime) + "ms");
		
		startTime = System.currentTimeMillis();
		comb(nums, new LinkedList<Integer>(), 0, nums.length, 9);
		endTime = System.currentTimeMillis();
		System.out.println("queue comb 程序运行时间： "+(endTime - startTime) + "ms");
		
		startTime = System.currentTimeMillis();
		comb(nums, new Vector<Integer>(), 0, nums.length, 9);
		endTime = System.currentTimeMillis();
		System.out.println("vector comb 程序运行时间： "+(endTime - startTime) + "ms");
		
	}
	
	
	public static void permutation(int[] nums, int[] per, boolean[] vis, int x) {
		if (x == nums.length) {
//			for (int p : per) {
//				System.out.print(p + " ");
//			}
//			System.out.println();
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!vis[i]) {
				vis[i] = true;
				per[x] = nums[i];
				permutation(nums, per, vis, x + 1);
				vis[i] = false;
			}
		}
	}
	
	public static void permutation(int[] nums, int i) {

		if (i == nums.length) {
//			for (int p : nums) {
//				System.out.print(p + " ");
//			}
//			System.out.println();
		}
		for (int j = i; j < nums.length; j++) {
			swap(nums, i, j);
			permutation(nums, i + 1);
			swap(nums, i, j);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		if (nums[i] != nums[j]) {
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
		}
	}
	
	// [start, end)的size个数的组合vc
	public static void comb(int[] nums, Vector<Integer> vc, int start, int end, int size) {
	    if (size == 0) {
	       
	    }
	    if (start >= end) return;
	    vc.add(nums[start]);
	    comb(nums, vc, start + 1, end, size - 1);
	    vc.remove(vc.size() - 1);
	    comb(nums, vc, start + 1, end, size);
	}
	
	// [start, end)的size个数的组合vc
	public static void comb(int[] nums, Queue<Integer> queue, int start, int end, int size) {
	    if (size == 0) {
	        
	        return;
	    }
	    if (start >= end) return;
	    queue.add(nums[start]);
	    comb(nums, queue, start + 1, end, size - 1);
	    queue.poll();
	    comb(nums, queue, start + 1, end, size);
	}
}
