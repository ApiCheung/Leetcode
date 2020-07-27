package Tree.InOrder;

/**
 * @author Esmee Zhang
 * @date 7/26/20 8:55 下午
 * @projectName Leetcode
 */
public class RecoverTree {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    TreeNode x = null, y = null, pred = null;
    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);


    }
    public void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void findTwoSwapped(TreeNode root){
        if(root == null) return;
        findTwoSwapped(root.left);
        if(pred != null && root.val < pred.val){
            y = root;
            if(x == null) x= pred;
            else return;
        }
        pred = root;
        findTwoSwapped(root.right);


    }

}
