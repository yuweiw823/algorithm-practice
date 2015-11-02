Leetcode 134 - Gas Station.java

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int p = -1;
        
        for(int i=0; i<gas.length; i++){
            int diff = gas[i] - cost[i];
            sum += diff;
            total += diff;
            if(sum<0){
                sum = 0;
                p = i;
            }
        }
        return total >= 0 ? p+1 : -1;
    }
}