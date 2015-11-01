//Leetcode 118 - Pascal's Triangle.java

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows <= 0) return res;
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        res.add(pre);
        
        for(int i=2; i<=numRows; i++){
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for(int j=1; j<pre.size(); j++){
                row.add(pre.get(j-1) + pre.get(j));
            }
            row.add(1);
            res.add(row);
            pre = row;
        }
        return res;
    }
}