// Leetcode 121 - Best Time to Buy and Sell Stock.java

// 自己的解法：Keep一个最低进价

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

// Java大神的解法
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int global = 0;
        int local =0;

        for(int i=0; i<prices.length-1; i++){
            local = Math.max(local+prices[i+1]-prices[i], 0);
            global = Math.max(local, global);
        }

        return global;
    }
}

