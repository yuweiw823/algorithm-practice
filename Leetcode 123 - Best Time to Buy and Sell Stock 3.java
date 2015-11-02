// Leetcode 123 - Best Time to Buy and Sell Stock 3.java

// 方法1：从前扫一次，再从后扫一次
// trans1[i] 表示从第1天到第i天最划算的一次交易，trans2[i]表示从i天到最后1天最划算的交易
// trans1[i] 和 trans2[i+1] 中最大的就是最划算的两次交易了
// trans2 使用从后往前扫，为了防止之前的值会被覆盖
// 使用这种方法是，必须用 local = Math.max(local + prices[i+1]-prices[i], 0); 而不能用那种keep lowest prices的方法，否则计算 trans2 的时候会出错

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) return 0;
        int[] trans1 = trans1Max(prices);
        int[] trans2 = trans2Max(prices);
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<prices.length-1; i++){
            max = Math.max(trans1[i] + trans2[i+1], max);
        }
        return max;
    }
    
    public int[] trans1Max(int[] prices){
        int local = 0;
        int global = 0;
        int[] trans1 = new int[prices.length];
        for(int i=0; i<prices.length-1; i++){
            local = Math.max(local+prices[i+1]-prices[i], 0);
            global = Math.max(local, global);
            trans1[i] = global;
        }
        return trans1;
    }

    public int[] trans2Max(int[] prices){
        int local = 0;
        int global = 0;
        int[] trans2 = new int[prices.length];
        for(int i=prices.length-2; i>=0; i--){
            local = Math.max(local+prices[i+1]-prices[i], 0);
            global = Math.max(local, global);
            trans2[i] = global;
        }
        return trans2;
    }
}



// 方法2：Java大神的解法
public int maxProfit(int[] prices) {  
    if(prices==null || prices.length==0)  
        return 0;  
    int[] local = new int[3];  
    int[] global = new int[3];  
    for(int i=0;i<prices.length-1;i++)  
    {  
        int diff = prices[i+1]-prices[i];  
        for(int j=2;j>=1;j--)  
        {  
            local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);  
            global[j] = Math.max(local[j],global[j]);  
        }  
    }  
    return global[2];  
}  
