Leetcode 095 - Unique Binary Search Trees 2 - 类似 NP 问题.java

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int left, int right){
        List<TreeNode> res = new ArrayList<TreeNode>();  
        if(left > right){
            res.add(null);//加入一个null表明这是一个空树
            return res;
        }
        for(int i=left; i<=right; i++){
            List<TreeNode> leftlist  = helper(left, i-1);
            List<TreeNode> rightlist = helper(i+1, right);
            for(int j=0; j<leftlist.size(); j++){
                for(int k=0; k<rightlist.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftlist.get(j);
                    root.right = rightlist.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}

试运行 n = 5
TreeNode 可以有 1，2，3，4，5
root及左右子树分配的情况：(i循环)
null - 1 - 2345
1 - 2 - 345
12 - 3 - 45
123 - 4 -5
1234 - 5 - null
然后再使用j和k循环，取root的left和right