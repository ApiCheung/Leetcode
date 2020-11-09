//207
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	//每个节点的入度
    	//使用queue来记录入度为0的node 如果queue里面不是空就是返回false
    	Queue<Integer> q = new LinkedList<>();
    	//将 preqiostoes 转换成hashmap
    	HashMap<Integer, List<Integer>> map = new HashMap<>();
    	//also need a list to remeber the in degree
    	int[] inDegree = new int[numCourses];

    	if(prerequisites == null && prerequisites.length == 0) return true;

    	for(int i = 0; i < prerequisites.length; i++){
    		inDegree[prerequisites[i][0]] ++;
    		if(map.containsKey(prerequisites[i][1])){
    			map.get(prerequisites[i][1]).add(prerequisites[i][0]);
    		}else{
    			ArrayList<Integer> list = new ArrayList<>();
    			list.add(prerequisites[i][0]);
    			map.put(prerequisites[i][1], list);
    		}
    	}

    	for(int i = 0; i < numCourses; i++){
    		if(inDegree[i] == 0) q.offer(i);

    	}

    	while(!q.isEmpty()){
    		int course = q.poll();
    		List<Integer> subcourses = map.get(course);
    		for(int i = 0; subcourses != null && i < subcourses.size(); i++){
    			if(--inDegree[subcourses.get(i)] == 0) q.offer(subcourses.get(i));
    		}
    	}

    	for(int i=0; i < numCourses; i++){
    		if(inDegree[i] != 0) return false;
    	}

    	return true;
        
    }
}