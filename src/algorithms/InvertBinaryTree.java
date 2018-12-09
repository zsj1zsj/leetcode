package algorithms;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if(root ==null)return root;
		TreeNode head = root;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return head;
	}

	public static void main(String[] args) {

	}

}
