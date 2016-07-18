Lintcode 149 - Best Time to Buy and Sell Stock.java

public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i< prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}


Lintcode 150 - Best Time to Buy and Sell Stock 2.java
class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        //一旦卖出，buy = price[i];
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            } else {
                buy = Math.min(buy, prices[i]);
            }
        }
        return profit;
    }
};

//标准答案：和自己上面写的其实一个思路
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i+1] - prices[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
}

Lintcode 151 - Best Time to Buy and Sell Stock 3.java
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        // write your code here
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        left[0] = 0;
        int min = prices[0];
        for(int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i-1], prices[i] - min);
        }
        
        right[len-1] = 0;
        int max = prices[len-1];
        for(int j = len - 2; j >=0; j--) {
            max = Math.max(max, prices[j]);
            right[j] = Math.max(right[j + 1], max - prices[j]);
        }
        
        int profit = 0;
        for(int k = 0; k < len; k++) {
            profit = Math.max(profit, left[k] + right[k]);
        }
        
        return profit;
    }
};