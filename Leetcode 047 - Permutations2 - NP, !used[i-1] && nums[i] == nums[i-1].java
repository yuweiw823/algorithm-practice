Leetcode 047 - Permutations2 - NP, !used[i-1] && nums[i] == nums[i-1].java


public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        boolean[] used = new boolean[nums.length];
        
        List<Integer> item = new ArrayList<Integer>();
        Arrays.sort(nums);
        DFS(nums, used, result, item);
        
        return result;
        
    }
    
    public void DFS(int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> item) {
        if(item.size() == nums.length) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && !used[i-1] && nums[i] == nums[i - 1]) {
                continue;
            }
            
            if(used[i]) {
                continue;
            }
            
            used[i] = true;
            item.add(nums[i]);
            DFS(nums, used, result, item);
            item.remove(item.size() - 1);
            used[i] = false;
        }
    }
}