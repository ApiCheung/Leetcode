class Solution {
    int count =0;
    int res = 0;
public int kthSmallest(TreeNode root, int k){
	inOrder(root, k);
	return res;
}

public void inOrder(TreeNode root, int k){
	if(root == null) return;

	inOrder(root.left, k);
	count ++;
	if(count == k) res = root.val;
	inOrder(root.right, k);
}
}