package priv.ifan.tsai;

public class InserationSort {

	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Test.generateRandomArr(maxSize, maxValue);
			int[] testArr = Test.copyArr(arr);
			int[] copyArr = Test.copyArr(testArr);
			
			inserationSort(arr, 0, arr.length - 1);
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
	
	private static void inserationSort(int[] arr, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			for (int j = i; j - 1 >= 0 && arr[j] < arr[j - 1]; j--) {
				swap(arr, j, j - 1);
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
