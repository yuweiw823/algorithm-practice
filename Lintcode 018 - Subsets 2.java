Lintcode 018 - Subsets 2.java

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(nums == null || nums.size() == 0) {
            return result;
        }
        
        Collections.sort(nums);
        dfs(result, list, nums, 0);
        return result;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums, int pos) {
        result.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.size(); i++) {
            if(i != pos && nums.get(i) == nums.get(i - 1)) {
                continue;
            }
            list.add(nums.get(i));
            dfs(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
