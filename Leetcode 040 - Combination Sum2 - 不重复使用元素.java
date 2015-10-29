//Leetcode 040 - Combination Sum2 - 不重复使用元素.java

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num == null || num.length==0) return res;
        Arrays.sort(num);
        helper(num,0,target,new ArrayList<Integer>(),res);
        return res;
    }
    
    private void helper(int[] num, int start, int target, List<Integer> item, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if(target<0 || start>=num.length) return;
        for(int i=start;i<num.length;i++){
            if(i>start && num[i]==num[i-1]) continue;  //*重要,如题example的[1,1,6]，第二个会在 helper(num, i+1...)这里的i+1里算进去 ，所以跳过重复元素
            item.add(num[i]);
            helper(num,i+1,target-num[i],item,res);
            item.remove(item.size()-1);
        }
    }
}

