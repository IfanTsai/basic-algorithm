package priv.ifan.tsai;

import java.util.Arrays;

public class MaxGap {

	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Test.generateRandomArr(maxSize, maxValue);
			int res1 = rightMethod(arr);
			int res2 = maxGap(arr);
			if (res1 != res2) {
				succed = false;
				Test.printArr(arr);
				System.out.println(res1);
				System.out.println(res2);
				break;
			}
		}
		System.out.println(succed ? "Nice!" : "Fucking fucked!");
	}
	
	private static int rightMethod(int[] arr) {
		int res = 0;
		int[] copyArr = Test.copyArr(arr);
		Arrays.sort(copyArr);
		int lastNum = copyArr[0];
		for (int i = 1; i < copyArr.length; i++) {
			res = Math.max(res, copyArr[i] - lastNum);
			lastNum = copyArr[i];
		}
		return res;
	}
	
	private static int maxGap(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
		if (min == max) {
			return 0;
		}
		
		int[] minBukkets = new int[len + 1];
		int[] maxBukkets = new int[len + 1];
		boolean[] hasNum = new boolean[len + 1];
		for (int i = 0; i < len; i++) {
			int index = getBukketIndex(arr[i], len, min, max);
			minBukkets[index] = hasNum[index] ? Math.min(minBukkets[index], arr[i]) : arr[i];
			maxBukkets[index] = hasNum[index] ? Math.max(maxBukkets[index], arr[i]) : arr[i];
			if (!hasNum[index]) {
				hasNum[index] = true;
			}
		}
		
		int res = 0;
		int lastMax = maxBukkets[0];
		for (int i = 1; i < len + 1; i++) {
			if (hasNum[i]) {
				res = Math.max(res, minBukkets[i] - lastMax);
				lastMax = maxBukkets[i];
			}
		}
		
		return res;
	}
	
	private static int getBukketIndex(long num, long len, long min, long max) {
		return (int) ((num - min) * len / (max - min));
	}
	

}
