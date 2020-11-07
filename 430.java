//430
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

//use a stack to store then next and process the curr node that have the child


class Solution {
    public Node flatten(Node head) {
        
    	if(head == null){
    		return head;
    	}

    	Stack<Node> stack = new Stack<>();
    	Node cur = head;
    	while(cur != null){
    		if(cur.child != null){
    			if(cur.next != null){
    				stack.push(cur.next);
    			}

    			cur.next = cur.child;
    			cur.child.prev = cur;
    			cur.child = null;
    		}else{
    			//no child
    			if(cur.next == null && !stack.isEmpty()){
    				cur.next = stack.pop();
    				cur.next.prev = cur;

    			}
    		}

    		cur = cur.next;
    	}

    	return head;

    
    }
}
/*
stack。      （456）
				（9 10） （456）

				 /9 10  /4 5 6 