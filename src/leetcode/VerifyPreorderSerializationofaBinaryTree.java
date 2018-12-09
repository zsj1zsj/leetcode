package leetcode;

public class VerifyPreorderSerializationofaBinaryTree {
	public boolean isValidSerialization(String preorder) {
		if (preorder.trim().equals("") || preorder == null)
			return false;

		String[] pre = preorder.split(",");

		int len = pre.length;

		//size meet full tree
		if (len != Math.pow(2, Math.ceil(Math.log(len) / Math.log(2)))-1)
			return false;
		
		
		for(int i = 0;i<len;i++){
			if(pre[i].equals("#")){
				
			}
		}

		return true;
	}

	public static void main(String[] args) {
		VerifyPreorderSerializationofaBinaryTree v = new VerifyPreorderSerializationofaBinaryTree();

		System.out.println(v.isValidSerialization("1,2"));
	}
}
