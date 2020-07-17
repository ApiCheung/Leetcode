package DP;

/**
 * @author Esmee Zhang
 * @date 7/17/20 5:00 下午
 * @projectName Leetcode
 */
public class MaximumProductSubarray {
    /*
        the status of the dp
        dp[i] 0 to i the max product subarray but do not need to from 0
        so it need to calculate the max dp[n-1] maybe exit in dp[n-2] ...
        to dp[0]
        dp[i][2] 0 for max 1 for min

        the transform function of the dp
        dp[i + 1] = dp[i] * a[i+1]
        but this do not consider the number is the negative number so
        we need to find the min and max number

        so the transform function become
        dp[i, 0] = a[i] > 0 ? dp[i - 1 , 0] * a[i] : dp[i-1, 1] * a[i];

        dp[i, 1] = a[i] > 0 ? dp[i-1, 1] * a[i] : dp [i-1, 0] * a[i];

    */
    public int maxProduct(int[] nums) {
        if (nums.length ==0) return 0;

        int[][] dp = new int[2][2];
        dp[0][1] = nums[0];
        dp[0][0] = nums[0];
        int res = nums[0];

        for(int i=1; i < nums.length; i++){
            /*
            * ues this way to make the 2 dimension array be the 2 * 2 roll the array
            * */
            int x = i % 2;
            int y = (i - 1) %2;
            dp[x][0] = Math.max(Math.max(dp[y][0] * nums[i], dp[y][1] *nums[i]), nums[i]);
            dp[x][1] = Math.min(Math.min(dp[y][0] * nums[i], dp[y][1] *nums[i]), nums[i]);
            res = Math.max(res, dp[x][0]);
        }
        return res;

    }



}
