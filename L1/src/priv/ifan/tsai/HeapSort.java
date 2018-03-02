package priv.ifan.tsai;

public class HeapSort {

	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Test.generateRandomArr(maxSize, maxValue);
			int[] testArr = Test.copyArr(arr);
			int[] copyArr = Test.copyArr(testArr);
			
			heapSort(arr);
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
	
	private static void heapSort(int[] arr) {
		// 调整为大根堆
		for (int i = 0; i < arr.length; i++) {
			insertHeap(arr, i);
		}
		int heapSize = arr.length;
		while (heapSize > 0) {
			// 将堆顶的元素与最后一个元素交换，并让堆的大小减一
			swap(arr, 0, --heapSize);
			// 将堆顶的元素向下调整为大根堆
			heapify(arr, 0, heapSize);
		}
	}

	// 向下调整为大根堆
	private static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		while (left < heapSize) {
			int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[index] > arr[largest] ? index : largest;
			if (largest == index) {
				break;
			}
			swap(arr, index, largest);
			index = largest;
			left = index * 2 + 1;
		}
	}

	// 向上调整为大根堆
	private static void insertHeap(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, (index - 1) / 2, index);
			index = (index - 1) / 2;
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
