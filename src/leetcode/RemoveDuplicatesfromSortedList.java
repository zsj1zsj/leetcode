package leetcode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode p = head, c = head.next;

		while (p.next != null && c != null) {
			if (p.val != c.val) {
				p.next = c;
				p = p.next;
				c = c.next;
			} else {
				c = c.next;
			}
		}
		p.next = null;
		return head;
	}

	public static void main(String[] args) {
		int[] nums = {};
		ListNode head = ListNode.constructList(nums);

		RemoveDuplicatesfromSortedList rds = new RemoveDuplicatesfromSortedList();

		head = rds.deleteDuplicates(head);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
