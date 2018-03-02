package priv.ifan.tsai;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 随时找到数据流的中位数
 * 
 * 题目:
 * 有一个源源不断地吐出整数的数据流, 假设你有足够的空间来保存吐出的数.
 * 请设计一个名叫MedianHolder的结构, MedianHolder可以随时取得之前吐出所有数的中位数.
 * 要求:
 * 1． 如果MedianHolder已经保存了吐出的N个数, 那么任意时刻将一个新数加入到MedianHolder的过程, 其时间复杂度是O(logN).
 * 2． 取得已经吐出的N个数整体的中位数的过程, 时间复杂度为O(1).
 */
public class MedianHolder {
	// 准备两个优先队列(堆),一个大根堆,一个小根堆,大根堆存放前一半的数,小根堆存放后一半的数
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new MaxHeapComparator());
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(1, new MinHeapComparator());
	
	// 第一个数放在大根堆中,之后如果小于大根堆堆顶,则放入小根堆中,否则放在小根堆中
	public void add(int num) {
		if (maxHeap.isEmpty()) {
			maxHeap.add(num);       // 堆的add和poll的时间复杂度都为O(logN)
		} else if (num <= maxHeap.peek()) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}
		// 平衡: 如果放完后发现两堆的大小相差为2,则将大的堆弹出一个放入另一个堆
		if (Math.abs(maxHeap.size() - minHeap.size()) == 2) {
			if (maxHeap.size() > minHeap.size()) {
				minHeap.add(maxHeap.poll());
			} else {
				maxHeap.add(minHeap.poll());
			}
		}
	}
	
	public int getMedian() {
		// 两堆大小不一样,则必有一个堆的堆顶为中位数; 否则,区两堆顶的平均值
		if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else if (maxHeap.size() < minHeap.size()) {
			return minHeap.peek();
		} else {
			return (maxHeap.peek() + minHeap.peek()) / 2;
		}
	}
	
	public class MaxHeapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}
	
	public class MinHeapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	}
	
	public static int rightMethod(int[] arr) {
		Arrays.sort(arr);
		int mid = arr.length / 2;
		if ((arr.length & 1) == 0) {     // 长度为偶数
			return (arr[mid] + arr[mid - 1]) / 2; 
		} else {                         // 长度为奇数
			return arr[mid];
		}
	}
	
	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 10;
		int maxValue = 10;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = Test.generateRandomArr(maxSize, maxValue);
			int[] testArr = Test.copyArr(arr);
			int[] copyArr = Test.copyArr(testArr);
			
			MedianHolder holder = new MedianHolder();
			for (int j = 0; j < arr.length; j++) {
				holder.add(arr[j]);
			}
			
			int res1 = holder.getMedian();
			int res2 = rightMethod(testArr);
			if (res1 != res2) {
				succed = false;
				Test.printArr(copyArr);
				Test.printArr(testArr);
				System.out.println(res1);
				System.out.println(res2);
				break;
			}
			
		}
		System.out.println(succed ? "Nice!" : "Fucking fucked!");
	}

}
