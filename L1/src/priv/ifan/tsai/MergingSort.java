package priv.ifan.tsai;

public class MergingSort {

	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Test.generateRandomArr(maxSize, maxValue);
			int[] testArr = Test.copyArr(arr);
			int[] copyArr = Test.copyArr(testArr);
			
			mergingSort(arr, 0, arr.length - 1);
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
	
	private static void mergingSort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			mergingSort(arr, lo, mid);
			mergingSort(arr, mid + 1, hi);
			merge(arr, lo, mid, hi);
		}
	}
	
	private static void merge(int[] arr, int lo, int mid, int hi) {
		int[] helpArr = new int[hi - lo + 1];
		int p1 = lo, p2 = mid + 1;
		int i = 0;
		// 将两路中更小的数依次放入辅助数组
		while (p1 <= mid && p2 <= hi) {
			helpArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		// 两路有且仅有一路剩余，所以下面的两个循环必然只会执行其中一个
		// 左路还有剩余
		while (p1 <= mid) {
			helpArr[i++] = arr[p1++];
		}
		// 右路还有剩余
		while (p2 <= hi) {
			helpArr[i++] = arr[p2++];
		}
		// 将辅助数组中的值重新放回原数组
		for (int j = 0; j < helpArr.length; j++) {
			arr[lo + j] = helpArr[j];
		}
	}

}
