Leetcode 046 - Permutations - NP, boolean[] used.java

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> item = new ArrayList<Integer>();
        DFS(nums, item, result);
        return result;
    }
    
    public void DFS(int[] nums, List<Integer> item, List<List<Integer>> result) {
        if(item.size() == nums.length) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(item.contains(nums[i])) {
                continue;
            }
            item.add(nums[i]);
            DFS(nums, item, result);
            item.remove(item.get(item.size() - 1));
        }
    }
}