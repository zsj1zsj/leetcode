package leetcode;

import java.util.List;

public class BinaryTreeInorderTraversal {

	static public List<Integer> inorderTraversal(TreeNode root) {
		TreeNode curr = root;

		
		if (curr.left != null)
			inorderTraversal(curr.left);
		System.out.println(curr.val);
		if (curr.right != null)
			inorderTraversal(curr.right);
		return null;
	}
	static public List<Integer> inorderTraversal2(TreeNode root) {
		
		return null;
	}

	public static void main(String[] args) {

		Integer[] input = { 1, null, 2, 3,5 };

		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);

		inorderTraversal(root);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
