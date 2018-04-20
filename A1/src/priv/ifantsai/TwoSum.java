package priv.ifantsai;

import java.util.HashMap;

/*
 * 题目:
 * 给定一个数组arr， 和一个整数aim， 请返回哪两个位置的数可以加出aim来。
 * 例如
 * arr = {2, 7, 11, 15}， target = 9
 * 返回{0,1}， 因为arr[0] + arr[1] = 2 + 7 = 9
 * 可以假设每个数组里只有一组答案
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] arr = { 2, 8, 7, 3, 11, 15 };
		int aim = 13;
		int[] index = getSumIndex1(arr, aim);
		System.out.println(index[0] + "  " + index[1]);
		index = getSumIndex2(arr, aim);
		System.out.println(index[0] + "  " + index[1]);
	}
	
	// 法一: 时间复杂度O(n), 空间复杂度为O(n), 
	// 由于引进了哈希表, 所以常数项大
	public static int[] getSumIndex1(int[] arr, int aim) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int need = aim - arr[i];
			if (map.containsKey(need)) {
				return new int[] { map.get(need), i };
			}
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			}
		}
		return new int[] { -1, -1};
	}
	
	// 法二: 时间复杂度O(nlogn), 空间复杂度为O(n), 
	// 虽然相比法一, 时间复杂度高了, 但是常数项小
	public static int[] getSumIndex2(int[] arr, int aim) {
		int[] indices = heapSort(arr);
		int p1 = 0, p2 = arr.length - 1;
		while (p1 < p2) {
			if (arr[p1] + arr[p2] < aim) {
				p1++;
			} else if (arr[p1] + arr[p2] > aim) {
				p2--;
			} else {
				return new int[] { indices[p1], indices[p2] };
			}
		}
		return new int[] { -1, -1};
	}
	
	// 在传统的堆排序上改进, 
	// 用indices数组保存arr数组各数在排序前的索引, 每次交换的同时交换indices数组
	private static int[] heapSort(int[] arr) {
		int[] indices = new int[arr.length];
		for (int i = 0; i < indices.length; i++) {
			indices[i] = i;
		}
		// 调整为大根堆
		for (int i = 0; i < arr.length; i++) {
			insertHeap(arr, i, indices);
		}
		int heapSize = arr.length;
		while (heapSize > 0) {
			// 将堆顶的元素与最后一个元素交换，并让堆的大小减一
			swap(arr, 0, --heapSize, indices);
			// 将堆顶的元素向下调整为大根堆
			heapify(arr, 0, heapSize, indices);
		}
		return indices;
	}

	// 向下调整为大根堆
	private static void heapify(int[] arr, int index, int heapSize, int[] indices) {
		int left = index * 2 + 1;
		while (left < heapSize) {
			int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[index] > arr[largest] ? index : largest;
			if (largest == index) {
				break;
			}
			swap(arr, index, largest, indices);
			index = largest;
			left = index * 2 + 1;
		}
	}

	// 向上调整为大根堆
	private static void insertHeap(int[] arr, int index, int[] indeices) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, (index - 1) / 2, index, indeices);
			index = (index - 1) / 2;
		}
	}

	private static void swap(int[] arr, int i, int j, int[] indeices) {
		if (arr[i] != arr[j]) {
			arr[i] ^= arr[j];
			arr[j] ^= arr[i];
			arr[i] ^= arr[j];
			
			indeices[i] ^= indeices[j];
			indeices[j] ^= indeices[i];
			indeices[i] ^= indeices[j];
		}
	}
}
