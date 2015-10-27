Leetcode 107 - Binary Tree Level Order Traversal 2 - 树层序遍历.java
// 维持一个queue，储存每一层的Node
// 每当遍历到一个Node，将Node的左右结点add到queue中，准备在下层的遍历中使用

// 和102代码一样，最后在return res之前
// Collections.reverse(res);  即可

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        List<Integer> level = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        
        int lastNum = 1;
        int curNum = 0;
        queue.add(root);   //queue是从后面进
        
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            level.add(cur.val);
            lastNum--;          //当前层的TreeNode的数量
            if(cur.left!=null){
                queue.add(cur.left);
                curNum++;       //下一层的TreeNode的数量
            }
            if(cur.right!=null){
                queue.add(cur.right);
                curNum++;
            }
            if(lastNum == 0){
                lastNum = curNum;
                curNum = 0;
                res.add(level);
                level = new LinkedList<Integer>();
            }
        }
        Collections.reverse(res);
        return res;
    }
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
}