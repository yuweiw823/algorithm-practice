Lintcode 015 - Permutations.java

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0) {
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(result, list, nums);
        return result;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums) {
        
        if(list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.size(); i++) {
            if(!list.contains(nums.get(i))) {
                list.add(nums.get(i));
                dfs(result, list, nums);
                list.remove(list.get(list.size()-1));
            }
        }
    }
}
