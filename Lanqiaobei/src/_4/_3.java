package _4;

public class _3 {
	static void f(int[] x, int left, int right)
	{
		if(left >= right) return;
		
		int key = x[(left+right)/2];
		
		int li = left;
		int ri = right;
		while(li<=ri){
			while(x[ri]>key) ri--;
			while(x[li]<key) li++;
			
			if(li <= ri){    //填空位置
				int t = x[li];
				x[li] = x[ri];
				x[ri] = t;
				li++;
				ri--;
			}	
		}
		
		if(li < right) f(x, li, right);
		if(ri > left) f(x, left, ri);
	}
	
	public static void main(String[] args) {
		int[] nums = { 8, 3, 5, 7, 9, 2};
		f(nums, 0, nums.length - 1);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
}
