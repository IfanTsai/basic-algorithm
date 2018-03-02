package priv.ifan.tsai;

public class SmallSum {

	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Test.generateRandomArr(maxSize, maxValue);
			int[] testArr = Test.copyArr(arr);
			int res1 = rightMethod(arr, 0, arr.length - 1);
			int res2 = mergingSort(testArr, 0, testArr.length - 1);
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
	
	private static int rightMethod(int[] arr, int lo, int hi) {
		int res = 0;
		for (int i = lo + 1; i <= hi; i++) {
			for (int j = lo; j < i; j++) {
				res += arr[j] < arr[i] ? arr[j] : 0;
			}
		}
		return res;
	}

	private static int mergingSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			return 0;
		}
		int mid = (lo + hi) / 2;
		return mergingSort(arr, lo, mid) + mergingSort(arr, mid + 1, hi) + merge(arr, lo, mid, hi);
	}

	private static int merge(int[] arr, int lo, int mid, int hi) {
		int[] helpArr = new int[hi - lo + 1];
		int p1 = lo, p2 = mid + 1;
		int res = 0;
		int i = 0;
		while (p1 <= mid && p2 <= hi) {
			res += arr[p1] < arr[p2] ? (hi - p2 + 1) * arr[p1] : 0;
			helpArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid) {
			helpArr[i++] = arr[p1++];
		}
		while (p2 <= hi) {
			helpArr[i++] = arr[p2++];
		}
		for (int j = 0; j < helpArr.length; j++) {
			arr[lo + j] = helpArr[j];
		}
		return res;
	}
}
