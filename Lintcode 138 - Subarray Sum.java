Lintcode 138 - Subarray Sum.java


//方法非常神奇！！！！
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int sum = 0;
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if(map.containsKey(sum)) {
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }
            
            map.put(sum, i);
        }
        
        return result;
        
    }
}