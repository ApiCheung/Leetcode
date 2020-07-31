package PriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Esmee Zhang
 * @date 7/30/20 8:05 下午
 * @projectName Leetcode
 */
public class MergeKSortedList {
    /*
    * popthe minium from the priority queue add to the new list
    * consider the k sorted queue as the priority queue
    * if it is null not pop
    *
    * time O(NKLOGK)
    * space O(K)
    * */

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    class NodeComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        if(lists == null || lists.length == 0 ) return dummy.next;
        int size = lists.length;
        ListNode curr = dummy;
        NodeComparator cmp = new NodeComparator();
        PriorityQueue<ListNode> queue = new PriorityQueue(cmp);
        for(int i=0; i<size; i++){
            if(lists[i] != null) queue.add(lists[i]);
        }
        while(queue.size() != 0){
            ListNode node = queue.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next != null) queue.add(node.next);
        }
        return dummy.next;

    }
}
