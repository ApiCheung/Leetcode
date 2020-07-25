package Tree.PostOrder;

/**
 * @author Esmee Zhang
 * @date 7/24/20 8:01 下午
 * @projectName Leetcode
 */
public class BinaryTreeMaximumPathSum {
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
    * use the postorder traverse
    * left -> right -> root
    * */
    int maxValue;
    public int maxPathSum(TreeNode root){

        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;

    }

    public int maxPathDown(TreeNode node){
        if(node == null) return 0;

        int left = Math.max(0, maxPathDown(node.left));
        int right  = Math.max(0, maxPathDown(node.right));

        maxValue = Math.max(maxValue, left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}
