package algorithms;

import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = null;

		levelOrderBottom(root, 0);

		return res;
	}

	void levelOrderBottom(TreeNode root, int level) {
		if (root == null)
			return;

		levelOrderBottom(root.left, level + 1);
		levelOrderBottom(root.right, level + 1);
		
		
	}

	public static void main(String[] args) {

	}
}
