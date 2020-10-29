//124

//just use the pre-order traverse
class Solution{
	int max;
	public int maxPathSum(TreeNode root){
		max = Integer.MIN_VALUE;
		helper(root);
		return max;
	}

	public int helper(TreeNode root){
		if(root == null) return 0;
		//trick to aoivd if/else if left < 0 then pick res from root and right+ val   if right < 0 is the same
		
		int left = Math.max(0, helper(root.left));
		int right = Math.max(0 helper(root.right));
		max = Math.max(max, left + ritgh + root.val);
		return Math.max(left, right) + root.val;
	}
}