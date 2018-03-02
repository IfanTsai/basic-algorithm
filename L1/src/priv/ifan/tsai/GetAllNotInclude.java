package priv.ifan.tsai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllNotInclude {

	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = Test.generateRandomArr(maxSize, maxValue);
			Arrays.sort(arr1);
			int[] arr2 = Test.generateRandomArr(maxSize, maxValue);
			List<Integer> list1 = rightMethod(arr1, arr2);
			List<Integer> list2 = getAllNotInclude(arr1, arr2);
			if (!isEqual(list1, list2)) {
				succed = false;
				Test.printArr(arr1);
				Test.printArr(arr2);
				printList(list1);
				printList(list2);
				break;
			}
		}
		System.out.println(succed ? "Nice!" : "Fucking fucked!");
	}
	
	private static List<Integer> rightMethod(int[] arr1, int[] arr2) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr2.length; i++) {
			boolean contain = false;
			for (int j = 0; j < arr1.length; j++) {
				if (arr2[i] == arr1[j]) {
					contain = true;
					break;
				}
			}
			if (!contain) {
				list.add(arr2[i]);
				//System.out.print(arr2[i] + " ");
			}
		}
		//System.out.println();
		return list;
	}
	
	private static List<Integer> getAllNotInclude(int[] arr1, int[] arr2) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr2.length; i++) {
			if (!find(arr1, arr2[i])) {
				//System.out.print(arr2[i] + " ");
				list.add(arr2[i]);
			}
		}
		//System.out.println();
		return list;
	}
	
	private static boolean find(int[] arr, int num) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (num < arr[mid]) {
				hi = mid - 1;
			} else if (num > arr[mid]) {
				lo = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isEqual(List<Integer> list1, List<Integer> list2) {
		if (list1 == null || list2 == null) {
			return false;
		}
		if (list1.size() != list2.size()) {
			return false;
		}
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	private static void printList(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

}
