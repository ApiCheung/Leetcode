//445
class Solution{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		int sum = 0;
		ListNode list = new ListNode(0);

		while(l1 != null){
			s1.push(l1.val);
			l1 = l1.next;
		}

		while(l2 != null){
			s2.push(l2.val);
			l2 = l2.next;
		}

		while(!s1.empty() || !s2.empty()){
			if(!s1.empty) sum += s1.pop();
			if(!s2.empty) sum += s2.pop();
			list.val = sum % 10;

			ListNodehead = new ListNode(sum/10);
			head.next = list;
			list = head;
			sum /= 10;
		}
		return list.val == 0? list.next : list;



	}
}
//2

class Solution{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode s = new ListNode(0);
		int sum = 0;
		ListNode s = s;

		while(l1 != null || l2 != mull){
			sum/=10;
			if(l1 !=null){
				sum+= l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				sum += l2.val;
			}

			d.next = new ListNode(sum % 10);
			d=d.next;
		}

		if(sum / 10 == 1) d.next = new ListNode(1);
		return s.next;
	}
}