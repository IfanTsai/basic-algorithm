package priv.ifan.tsai;

public class QuickSort {

	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Test.generateRandomArr(maxSize, maxValue);
			int[] testArr = Test.copyArr(arr);
			int[] copyArr = Test.copyArr(testArr);
			
			quickSort(arr, 0, arr.length - 1);
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
	
	private static void quickSort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			// 随机生成比较值  最后整个快速排序的时间复杂度在概率上的期望为O(n*logn)
			swap(arr, hi, lo + (int) (Math.random() * (hi - lo + 1)));
			int[] p = partition(arr,lo, hi);
			quickSort(arr, lo, p[0] - 1);
			quickSort(arr, p[1] + 1, hi);
		}
		
	}
	private static int[] partition(int[] arr, int lo, int hi) {
		int less = lo - 1;  // 小于区
		int more = hi + 1;  // 大于区
		int compareValue = arr[hi]; // 记录用来划分的值
		/*
		 * 遍历数组：
		 * 小于划分值，则将当前数与小于区的右边数交换，并让小于区向右扩一个，遍历的索引+1;
		 * 大于划分值，则将当前数与大于区左边的数互换，大于区向左扩一个，且让遍历的索引不动;
		 * 如果等于划分值，则只让遍历的索引+1
		 * 直到遍历的索引碰上大于区的左边界循环终止
		 */
		while (lo < more) {
			if (arr[lo] < compareValue) {
				swap(arr, ++less, lo++);   
			} else if (arr[lo] > compareValue) {
				swap(arr, --more, lo);
			} else {
				lo++;
			}
		}
		return new int[] { less + 1, more - 1 };
	}

	private static void swap(int[] arr, int i, int j) {
		if (arr[i] != arr[j]) {
			arr[i] ^= arr[j];
			arr[j] ^= arr[i];
			arr[i] ^= arr[j];
		}
	}

}
