Leetcode 047 - Permutations2 - NP, !used[i-1] && nums[i] == nums[i-1].java


public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length==0 || nums == null) return res;
        List<Integer> item = new ArrayList<Integer>();
        Arrays.sort(nums);  //*增加这句！！！
        boolean[] used = new boolean[nums.length];
        helper(nums, used, item, res);
        return res;
    }
    
    public void helper(int[] nums, boolean[] used, List<Integer>item, List<List<Integer>>res){
        if(item.size() == nums.length){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(i>0 && !used[i-1] && nums[i] == nums[i-1]) continue; //*增加这句！！！
            if(!used[i]){
                used[i] = true;
                item.add(nums[i]);
                helper(nums, used, item, res);
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }
}