//26

//2 pointer intuitively

class Solution {
    public int removeDuplicates(int[] nums) {
    if(nums.length == 0) return 0;
    int i = 0;
    for(int j : nums){
    if(nums[j] != nums[i]){
    i++;
    nums[i] = nums[j];
        
    }
    }
    return i+1;
    }
}

/**
	[0,0,1,1,1,2,2,3,3,4]
	i = 0 j=1  
	i = 0 j=2 i=1 nums[1] = nums[2] [0 1 0 1 1 2 2 3 3 4]
	-> [0 1 2 3 4 0 1 1 2 3]
*/