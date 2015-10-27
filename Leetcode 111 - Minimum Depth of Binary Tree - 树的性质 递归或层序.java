Leetcode 111 - Minimum Depth of Binary Tree - 递归或层序.java

递归解法：DFS遍历，返回左子树或者右子树中小的深度加1，作为自己的深度即可；但要先判断坐子树或者右子树为空的情况
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right)+1;
        if(root.right == null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}

非递归解法：BFS层序遍历，遇到 左子树和右子树都是 null 即返回
public class Solution {
    public int minDepth(TreeNode root) {
        int level = 0;
        if(root == null) return level;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int curNum = 0;
        int lastNum = 1;

        queue.offer(root);
        level = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            lastNum--;
            if(cur.left==null && cur.right==null){  //判断是否返回在这里
                return level;
            }
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
        return 0;
    }
}