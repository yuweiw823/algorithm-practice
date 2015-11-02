// Leetcode 122 - Best Time to Buy and Sell Stock 2.java

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int sum = 0;
        
        for(int i=1; i<prices.length; i++){
            int diff = prices[i] - prices[i-1];
            if(diff > 0){
                sum += diff;
            }
        }
        return sum;
    }
}