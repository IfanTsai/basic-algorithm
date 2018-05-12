package leetcode;

public class _61_Rotate_List {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode[] nums = new ListNode[len];
        cur = head;
        for (int i = 0; i < len; i++) {
            nums[i] = cur;
            cur = cur.next;
        }
        rotateRight(nums, k);
        /*for (int i = 0; i < len - 1; i++) {
            nums[i].next = nums[i + 1];
        }*/
        return nums[0];
    }
    
    public static void rotateRight(ListNode[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        while (k > nums.length) {
            k -= nums.length;
        }
        reverse(nums, 0, nums.length - k);
        reverse(nums, nums.length - k, nums.length);
        reverse(nums, 0, nums.length);
    }
    
    public static void reverse(ListNode[] nums, int lo, int hi) {
        for (int i = lo; i < lo + ( (hi - lo) >> 1 ); i++) {
            int t = nums[i].val;
            nums[i].val = nums[hi - 1 - i + lo].val;
            nums[hi - 1 - i + lo].val = t;
        }
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
    	
    	rotateRight(head, 2);
    	while (head != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
	}
}
