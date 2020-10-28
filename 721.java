//721 union find 
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for(List<String> a: accounts){
        	for(int i = 1; i < a.size(); i++){
      			parents.put(a.get(i), a.get(i));//一开始线先设置每一个邮箱的parent都是自己
      			owner.put(a.get(i), a.get(0));//每个账户和姓名对应
      		}
        }
        
        //将parents map中这些邮箱全部用每个账户里面的第一个邮箱作为parents
        for(List<String> a: accounts){
            String p = find(a.get(1), parents);
            for(int i = 2; i < a.size(); i++){
                parents.put(find(a.get(i), parents), p);
            }
        }
        
        //建立union set 根据之前parent的来查找

        for(List<String> a : accounts){
        	String p = find(a.get(1), parents);
        	if(!unions.containsKey(p)) unions.put(p, new TreeSet<>());
        	for(int i = 1; i < a.size(); i++)
        		unions.get(p).add(a.get(i));
        }

        //
        List<List<String>> res = new ArrayList<>();
        for(String p : unions.keySet()){
        	List<String> emails = new ArrayList(unions.get(p));
        	emails.add(0, owner.get(p));
        	res.add(emails);
        }

        return res;


    }

    private String find(String s, Map<String, String> p){
    	return p.get(s) == s ? s : find(p.get(s), p);
    }
}
