//582
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> children = new HashMap();

        //put all child related to their parent
        for(int i=0;i<pid.size(); i++){
        	Integer parent = ppid.get(i);
        	children.putIfAbsent(parent, new ArrayList());
        	child.get(parent).add(pid.get(i));
        }

        List<Integer> res = new ArrayList();
        Queue<Integer> q = new LinkedList();
        q.add(kill);

        while(!q.isEmpty()){
        	Integer current = q.poll();
        	res.add(current);
        	//need to return an enty LinkedList or will cause null pointer
        	q.addAll(children.getOrDefault(current, new LinkedList()));
        }

        return res;
    }
}