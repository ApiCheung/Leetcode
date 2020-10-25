//347

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Integer>[] buck = new ArrayList[nums.length + 1];
        for(int key : map.keySet()){
            int freq=map.get(key);
            if(buck[freq] == null) buck[freq] = new ArrayList();
            buck[freq].add(key);
        }
        
        int[] res = new int[k];
        int index = 0;
        for(int i = buck.length - 1; i >=0 ; i--){
            if(buck[i] != null){
                for(int n: buck[i]){
                    res[index++] = n;
                    if(index == k)
                        return res;
                }
            }
        }
        
        
        return res;
        
        
        
    }
}