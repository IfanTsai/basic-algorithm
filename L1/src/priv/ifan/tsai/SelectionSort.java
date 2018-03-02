package priv.ifan.tsai;

public class SelectionSort {

	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Test.generateRandomArr(maxSize, maxValue);
			int[] testArr = Test.copyArr(arr);
			int[] copyArr = Test.copyArr(testArr);
			
			selectionSort(arr, 0, arr.length - 1);
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

	// 选择排序可以实现为稳定版本,但一般认为基于数组实现的简单选择排序都为不稳定的
	private static void selectionSort(int[] arr, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			int minIndex = i;
			for (int j = i + 1; j <= hi; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		if (arr[i] != arr[j]) {
			arr[i] ^= arr[j];
			arr[j] ^= arr[i];
			arr[i] ^= arr[j];
		}
	}
}
