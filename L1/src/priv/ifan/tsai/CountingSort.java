package priv.ifan.tsai;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Test.generateRandomArr(maxSize, maxValue);
			int[] testArr = Test.copyArr(arr);
			int[] copyArr = Test.copyArr(testArr);
			
			countingSort(arr, 0, arr.length - 1);
			Test.rightSort(testArr, 0, testArr.length - 1);
			if (!Test.isEqual(arr, testArr)) {
				succed = false;
				Test.printArr(copyArr);
				Test.printArr(arr);
				Test.printArr(testArr);
				break;
			}
		}
		System.out.println(succed ? "Nice!" : "Fucking fucked!");
	}
	
	// 只适用于非负数组
	private static void countingSort(int[] arr, int lo, int hi) {
		// 寻找最大值，以确定范围
		int max = Integer.MIN_VALUE;
		for (int i = lo; i <= hi; i++) {
			max = Math.max(max, arr[i]);
		}
		// 建立容纳范围的桶，并将范围映射到[0, max]
		int[] bukkets = new int[max + 1];
		// 桶里装入各个数的数量
		for (int i = lo; i <= hi; i++) {
			bukkets[arr[i]]++;
		}
		int j = lo;
		// 将数倒入原数组
		for (int i = 0; i < bukkets.length; i++) {
			while (bukkets[i]-- > 0) {
				arr[j++] = i;
			}
		}
	}

	static class Test {
		public static int[] generateRandomArr(int maxSize, int maxValue) {
			int[] arr = new int[(int) (Math.random() * maxSize + 1)];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) (Math.random() * (maxValue + 1)) + (int) (Math.random() * (maxValue + 1));
			}
			return arr;
		}
		
		public static void rightSort(int[] arr, int lo, int hi) {
			Arrays.sort(arr, lo, hi + 1);
		}
		
		public static int[] copyArr(int[] arr) {
			int[] copyArr = new int[arr.length];
			for (int i = 0; i < copyArr.length; i++) {
				copyArr[i] = arr[i];
			}
			return copyArr;
		}
		
		public static boolean isEqual(int[] arr1, int[] arr2) {
			if (arr1 == null || arr2 == null) {
				return false;
			}
			if (arr1.length != arr2.length) {
				return false;
			}
			for (int i = 0; i < arr2.length; i++) {
				if (arr1[i] != arr2[i]) {
					return false;
				}
			}
			return true;
		}
		
		public static void printArr(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}
