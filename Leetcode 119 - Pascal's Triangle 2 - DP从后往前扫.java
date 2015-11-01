//Leetcode 119 - Pascal's Triangle 2 - DP从后往前扫.java

// 只用一行的空间来存储结果而不需要额外的来存储上一行呢？可以。
// 从后往前扫，这样每次需要的数据就是res[i]+res[i-1]，就需要的数据不会被覆盖。
// 因为需要的res[i]只在当前步用，下一步就不需要了。这个技巧在动态规划省空间时也经常使用。

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if (rowIndex < 0) return res;
        res.add(1);
        
        for(int i=1; i<=rowIndex; i++){
            for(int j=res.size()-1; j>=1; j--){
                res.set(j, res.get(j) + res.get(j-1));
            }
            res.add(1);
        }
        return res;
    }
}
