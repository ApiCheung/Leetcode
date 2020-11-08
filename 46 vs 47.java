//46 permutations
//need to use recurrsion
//保存当前状态前面的状态
//推出条件 size = inpu.size
class Solution{
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList();
		if(nums == null || nums.length == 0) return res;

		helper(res, new ArrayList<Integer>(), nums, new HashSet<Integer>());
		return res;
		
	}

	public void helper(List<List<Integer>> res, List<Integer> currList, int[] nums, HashSet<Integer> set){
		if(currList.size() == nums.length) res.add(new ArrayList<Integer>(currList));
		else{
			for(int i=0; i<nums.length; i++){
				if(!set.contains(nums[i])){
				currList.add(nums[i]);
				int last = currList.size() - 1;
				set.add(nums[i]);
				helper(res, currList, nums, set);
				set.remove(nums[i]);
				//
				currList.remove(last);
				}
			}
		}
	}
}

//如何做到去重
