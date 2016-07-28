Lintcode 135 - Combination Sum.java

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        
        Arrays.sort(candidates);
        dfs(result, list, candidates, target, 0);
        
        return result;
        
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] candidates, int target, int pos) {
        
        if(target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        if(target < 0) {
            return;
        }
        
        for(int i = pos; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(result, list, candidates, target - candidates[i], i);
            list.remove(list.size()-1);
        }
    }
}