//3 sliding window
class Solution{
	public int lengthOfLongestSubstring(String s){
		HashSet<Character> s = new HashSet<>();
		int i, j, res = 0;
		while(i < s.length() && j < s.length()){
			if(!contains(s.charAt(j))){
				set.add(s.charAt(j));
				j++;
				res = Math.max(res, j-i);
			}else{
				set.remove(s.charAt(i));
				i++;
			}
		}
		return res;
	}
}