package priv.ifan.tsai;

import java.util.Arrays;

public class Test {
	public static int[] generateRandomArr(int maxSize, int maxValue) {
		int[] arr = new int[(int) (Math.random() * maxSize + 1)];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
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
