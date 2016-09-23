Leetcode 098 - Validate Binary Search Tree - 二叉搜索树.java

方法1）中序遍历，比较前一个结点和当前结点，看是否升序排列
public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        return helper (root, pre);
    }
    
    public boolean helper(TreeNode root, List<TreeNode> pre){
        if(root == null) return true;
        boolean L = helper(root.left, pre);     //先看左子树。
        if(pre.get(0) != null && pre.get(0).val >= root.val) return false; //此时pre[0]就是左子树的值
        pre.set(0, root);//把当前的root存储到pre；最早进入到pre的值是全树Inorder的第二个结点，即第一个有叶子的根节点
        boolean R = helper(root.right, pre);
        return L && R;
    }
}

方法2）递归判定，keep 一个 min 和 max。但限制性哒，不推荐
如果输入只有一个结点的树，且其值为Integer的上界或下界，结果错误
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return myIsValidBST(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
    }
    
    public boolean myIsValidBST(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        
        if(root.val <= min || root.val >= max) {
            return false;
        }
        return myIsValidBST(root.left, min, root.val) && myIsValidBST(root.right, root.val, max);
    }
}