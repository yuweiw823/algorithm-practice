Leetcode 104 - Maximum Depth of Binary Tree - 递归或层序.java


递归解法：DFS遍历，返回左子树或者右子树中大的深度加1，作为自己的深度即可
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}

非递归解法：BFS层序遍历，返回最后的 level 即可
public class Solution {
    public int maxDepth(TreeNode root) {
        int level = 0;
        if(root == null) return level;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int curNum = 0;
        int lastNum = 1;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            lastNum--;
            if(cur.left!=null){
                queue.add(cur.left);
                curNum++;
            }
            if(cur.right!=null){
                queue.add(cur.right);
                curNum++;
            }
            if(lastNum==0){
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }
        return level;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {x = val;}
    }
}