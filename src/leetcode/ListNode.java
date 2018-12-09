package leetcode;

public class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
	}

	static ListNode constructList(int[] nums) {
		ListNode head = null;
		if (nums.length > 0) {
			head = new ListNode(nums[0]);
			ListNode c = head;
			for (int i = 1; i < nums.length; i++) {
				c.next = new ListNode(nums[i]);
				c = c.next;
			}
			return head;
		}
		return null;
	}
}
