package Tree.PreOrder;

import Tree.PostOrder.BinaryTreeMaximumPathSum;

/**
 * @author Esmee Zhang
 * @date 7/25/20 8:42 下午
 * @projectName Leetcode
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /*
    * pre root - left - right
    * in left - root - right
    * post left - right - root
    * */
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) return null;
        return helper(preorder, inorder, 0, 0, preorder.length -1);

    }

    public TreeNode helper(int[] preorder, int[] inorder, int pre_st, int in_st, int in_end){

        if(pre_st > preorder.length || in_st > in_end) return null;
        TreeNode curr = new TreeNode(preorder[pre_st]);
        int i = in_st;
        while(i <= in_end){
            if(inorder[i] == preorder[pre_st]) break;
            i++;
        }
        curr.left = helper(preorder, inorder, pre_st + 1, in_st, i - 1);
        curr.right = helper(preorder, inorder, pre_st+(i-in_st+1), i+1, in_end);

        return curr;

    }


}
