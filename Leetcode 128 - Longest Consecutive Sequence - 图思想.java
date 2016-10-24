Leetcode 128 - Longest Consecutive Sequence - 图思想.java

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        int res = 1;
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);    
        }
        while(!set.isEmpty()){
            Iterator iter = set.iterator();
            int item = (Integer)iter.next();
            int len = 1;
            set.remove(item);
            
            int i = item-1;
            while(set.contains(i)){
                set.remove(i);
                i--;
                len++;
            }
            i = item+1;
            while(set.contains(i)){
                set.remove(i);
                i++;
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}