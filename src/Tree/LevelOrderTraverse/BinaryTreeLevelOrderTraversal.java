package Tree.LevelOrderTraverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Esmee Zhang
 * @date 7/22/20 11:02 上午
 * @projectName Leetcode
 */
public class BinaryTreeLevelOrderTraversal {
    /*
    * queue
    * time O(N)
    * space O(N)
    * */

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        LinkedList<TreeNode> list = new LinkedList<TreeNode>();

        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            LinkedList<Integer> clist = new LinkedList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = list.pop();
                clist.add(node.val);
                if(node.left != null) list.add(node.left);
                if(node.right != null) list.add(node.right);
            }
            res.add(clist);
        }
        return res;
    }


}
