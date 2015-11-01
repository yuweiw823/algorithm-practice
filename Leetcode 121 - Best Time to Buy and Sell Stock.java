// Leetcode 121 - Best Time to Buy and Sell Stock.java

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;   //最低进价
        int max = 0;
        
        for(int i=0; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            max = Math.max(max, prices[i] - minPrice);
        }
        return max;
    }
}