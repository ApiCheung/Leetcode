package DP;

/**
 * @author Esmee Zhang
 * @date 8/4/20 7:53 下午
 * @projectName Leetcode
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int sum=0;
        int lowest = prices[0];
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > lowest){
                sum = Math.max(sum, prices[i] - lowest);
            }else{
                lowest = prices[i];
            }
        }
        return sum;
    }
}
