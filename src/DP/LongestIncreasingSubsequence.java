package DP;

import java.util.Arrays;

/**
 * @author Esmee Zhang
 * @date 7/20/20 7:14 下午
 * @projectName Leetcode
 */
public class LongestIncreasingSubsequence {
    /**
     * no need to be neighbor. So we need to find from start to i the longest
     * value is setted.
     *
     * transform function
     * DP[i] : from start to i element (include i) the longest subSequence length
     * DP[0],[1],...[N-1] all max
     *
     * for i: 0 -> n
     * DP[i] = MAX{DP[j] + 1}
     * j -> i - 1
     *
     * DP[I]
     * use binary search to maintanance
     * fot i:0 -> n-1
     *   insert into lis
     *   lis .size() is the result of the probelm
     *
     *   方法二 使用二分法插入数列， 保持长度为最优。每次替换插入来更新数列
     *
     */
    //method 1 n ^2
    public int lengthOfLIS(int[] nums){
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int maxans = 1;
            for (int i = 1; i < dp.length; i++) {
                int maxval = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        maxval = Math.max(maxval, dp[j]);
                    }
                }
                dp[i] = maxval + 1;
                maxans = Math.max(maxans, dp[i]);
            }
            return maxans;

    }

    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

}
