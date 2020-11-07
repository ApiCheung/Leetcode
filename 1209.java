//1209
//in the stack it save the accurance of the character
class Solution {
    public String removeDuplicates(String s, int k) {
    	Stack<Integer> occur = new Stack<>();
    	StringBuilder sb = new StringBuilder(s);

    	for(int i=0 ; i<sb.length(); i++){
    		if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)){
    			occur.push(1);
    	}else{
    		int incre = occur.pop() + 1;
    		if(incre == k){
    			sb.delete(i - k + 1, i + 1);
    			i = i - k;
    		}else{
    			occur.push(incre);
    		}
    	}
    	
        
    }
        return sb.toString();
    }
    
}