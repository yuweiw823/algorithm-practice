Lintcode 016 - Permutations II.java

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0) {
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        
        Collections.sort(nums);
        dfs(result, list, nums, used);
        
        return result;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums, boolean[] used) {
        
        if(list.size() == nums.size()) {
            result.add(new ArrayList(list));
            return; //go back to 上一步
        }
        
        for(int i = 0; i < nums.size(); i++) {
            //连续3个 && 条件，一个都不能少
            if(i > 0 && !used[i-1] && nums.get(i) == nums.get(i-1)) {
                continue;
            }

            if(used[i]) {
                continue;
            }
            
            list.add(nums.get(i));
            used[i] = true;
            dfs(result, list, nums, used);
            list.remove(list.size()-1);
            used[i] = false;

        }
    }
}
