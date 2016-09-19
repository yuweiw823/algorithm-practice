Lintcode 187 - Gas Station.java

public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        
        int n = gas.length;
        int total = 0;
        int sum = 0;
        int index = -1;
        
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i]; 
            total += gas[i] - cost[i];
            if(sum < 0) {
                sum = 0;
                index = i;
            }
        }

        
        return total >= 0 ? index + 1 : -1;
    }
}