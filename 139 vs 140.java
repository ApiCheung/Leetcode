//139
//dp
//need to find the state
// a b  c d e
//   i    j
//backward
//[i] = [j 1->i ] {substring (length is j ) in the dictionary }
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		//initial state b[0] -> true empty string
		if(s == null || wordDict == null) return false;

		Set<String> dict = new HashSet<String>();
		for(String str : wordDict){
			dict.add(str);
		}
		

		boolean[] breakable = new boolean[s.length() + 1];
		breakable[0] = true;

//从 长度是1 到长度是整个字符
		for(int i = 1; i < s.length(); i++){
			for(int j = i; j > 0; j--){
				String sub = s.subString(i-j, i);
				if(dict.contains(sub)){
					if(breakable[i-j] == true){
						breakable[i] = true;
						break;
					}
				}
			}

		}

		return breakable[s.length()];

		}
	}


//cannot use dp 
//need iterate 
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashMap<String, List<String>> used = new HashMap<>();
        for(String str ： wordDict){
        	set.add(str);
        }

        res = helper(s, set, used);
        return res;
    }

    public List<String> helper(String s, HashSet<String> set, HashMap<String, List<String>> used){
    	if(used.containsKey(s)){
    		return used.get(s);
    	}

    	if(s.length() == 0) return null;
    	List<String> res = new ArrayList<>();
    	//从头开始招长度为 1 2.。。的substring
    	for(int i = 1; i < s.length() + 1; i++){
    		String sub = s.substring(0, i);
    		List<String> partRes = null;
    		if(set.contains(sub)){
    			//对之后的string进行递归
    			partRes = helper(s.substring(i), set, used);
    			if(partRes == null){
    				res.add(sub);
    			}else{
    				for(String str : partRes){
    					res.add(sub + " " + str);
    				}
    			}

    		}

    	}
    	used.put(s, res);

    	return res;




    }
}