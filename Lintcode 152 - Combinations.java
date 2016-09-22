Lintcode 152 - Combinations.java

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// write your code here
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(n == 0 || k > n) {
		    return result;
		}
		
		ArrayList<Integer> item = new ArrayList<Integer>();
		
		dfs(result, item, n, k, 1);
		
		return result;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int n, int k, int pos) {
        
        if(item.size() == k) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = pos; i <= n; i++) {
            item.add(i);
            dfs(result, item, n, k, i + 1); // 注意这里是(i + 1)而不是(pos + 1)
            item.remove(item.size() - 1);
        }
    }
}