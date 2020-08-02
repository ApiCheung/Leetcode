package DP;

/**
 * @author Esmee Zhang
 * @date 8/2/20 4:03 下午
 * @projectName Leetcode
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;

        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int max;
        int temp;

        for(int i = 4; i<=n; i++){
            max = 0;
            for(int j = 1;j <= i/2; j++){
                temp = dp[j]*dp[i-j];
                if(max < temp) max = temp;

                dp[i] = max;
            }
        }
        max = dp[n];

        return max;
    }

}
