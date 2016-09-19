Lintcode 046 - Majority Number.java

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    //使用candidate 和 count
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return 0;
        }
        
        int count = 0;
        int candidate = -1;
        
        for(int i = 0; i < nums.size(); i++) {
            if(count == 0) {
                candidate = nums.get(i);
                count++;
            } else if(candidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}