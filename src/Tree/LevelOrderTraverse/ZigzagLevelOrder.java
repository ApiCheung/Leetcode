package Tree.LevelOrderTraverse;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Esmee Zhang
 * @date 7/22/20 9:48 上午
 * @projectName Leetcode
 */
public class ZigzagLevelOrder {
    /*
    * BFS need 2 parameter track the level and node
    * if it is odd level left to right if it is even right to left
    *
    * traverse the tree with level.
    * use queue to take the node
    * need to know the size of the current level how many nodes need
    * to be process but need to consider the order that add into the list
    * right left or left right
    * 23
    * 672
    * 4567
    * insert into the head of the list
    *
    * use linkedlist
    *
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        boolean leftToRight = true;
        list.add(root);

        while(!list.isEmpty()){
            int size = list.size();
            LinkedList<Integer> clist = new LinkedList<Integer>();
            if(leftToRight){
                for(int i = 0; i < size; i++){
                    TreeNode curr = list.remove(0);
                    clist.add(curr.val);
                    //add to the head of the list
                    if(curr.left != null) list.add(curr.left);
                    if(curr.right != null) list.add(curr.right);

                }
            }else{
                for(int i = 0; i < size; i++){
                    TreeNode curr = list.remove(list.size() - 1);
                    clist.add(curr.val);
                    if(curr.right != null) list.add(0, curr.right);
                    if(curr.left !=null) list.add(0, curr.left);
                }
            }
            res.add(clist);
            leftToRight =! leftToRight;

        }
        return res;





    }
}
