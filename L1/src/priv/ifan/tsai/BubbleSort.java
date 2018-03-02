package priv.ifan.tsai;

public class BubbleSort {
	
	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Test.generateRandomArr(maxSize, maxValue);
			int[] testArr = Test.copyArr(arr);
			int[] copyArr = Test.copyArr(testArr);
			
			bubbleSort(arr, 0, arr.length - 1);
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
	
	private static void bubbleSort(int[] arr, int lo, int hi) {
		boolean isSorted = false;
		for (int i = lo; i < hi && !isSorted; i++) {
			isSorted = true;
			for (int j = lo; j < hi - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					isSorted = false;
				}
			}
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
