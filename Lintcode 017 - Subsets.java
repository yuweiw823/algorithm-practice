Lintcode 017 - Subsets.java

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        dfs(result, list, nums, 0);
        return result;
        
    }
    
    public void dfs (ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int pos) {
        
        result.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.remove(list.size()-1);
        }
    }
    
    //[[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
}