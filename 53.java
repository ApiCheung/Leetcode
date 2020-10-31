//53
/**
	a dp problem 
	*/
class Solution {
    public int maxSubArray(int[] nums) {
    //need to record the maximum subarry at the point i
    int[] dp = new int[n];
    dp[0] = nums[0];
    int max = dp[0];

    for(int i=1; i < nums.length; i++){
    	dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i - 1] : 0);
    	max = Math.max(max, dp[i]);
        
    }

    return max;
    }
}
/**
	[-2,1,-3,4,-1,2,1,-5,4]
	dp[0] = -2 max = -2 
	dp[1] = 1 + (-2 > 0) -> 1 max = (-2, 1) -> 1
	dp[2] = -3 + (dp[1] > 0 ? +1 -> -2 max ->1
	dp[3] = 4 + (dp[2] < 0 -> + 0) max -> 4
	dp[4] = -1 + dp[3] > 0 -> + 4 = 3 max ->4
	dp[5] = 2 + dp[4] -> 3 =5 max = 5
	dp[6] = 1 + dp[5] -> 5 max = 6
	dp[7] = -5 + dp[6]->6 = -1 max = 6
	dp[8] = 4 + dp[7] -> -1 max = 6
	*/