//105
class Soluction{
	public TreeNode buildTree(int[] preorder, int[] inorder){
		if(preorder == null || inorder == null) return null;
		//两个size 一样 用一个
		return helper(preorder, inorder, 0, 0, preorder.length-1);
	}
//
	public TreeNode helper(int[] preorder, int[] inorder, int pre_st, int in_st, int in_end){
		//
		if(pre_st > preorder.length || in_st > in_end) return null;
		
		//each time find the root;
		TreeNode current = new TreeNode(preorder[pre_st]);

		//在inorder中 找到pre中root的位置
		int i = in_st;
		while(i < in_end){
			if(inorder[i] == preorder[pre_st]) break;
			i++;
		}

		//                                      pre 的 root。  in——st 和 in——end
		current.left = helper(preorder, inorder, pre_st + 1, in_st, i-1);
		//                                                  left 树的长度 in——st in_end       
		current.right = helper(preorder, inorder, pre_st + (i-in_st+1), i+1, in_end);

		return current;
	}
}