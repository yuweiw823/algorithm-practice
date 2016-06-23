Lintcode 088 - Lowest Common Ancestor
http://www.lintcode.com/en/problem/lowest-common-ancestor/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

方法1：递归分治法
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        //思路相当于检查每一个点，看每个点是不是A，B的ancestor，
        //由DFS的顺序保证找到的第一个点一定是lowest
        if(left != null && right != null) {
            return root;
            //直接返回 root 不需往下寻找，左右子树经过之前的抽象，就相当于A、B两个Node
        }
        if(left != null) {
            return left; 
            //仅有left，返回左子树，将左子树抽象成一个Node，而A Node必在这个子树中
        }
        if(right != null) {
            return right; 
            //仅有right，返回右子树，将右子树抽象成一个Node，而B Node必在这个子树中
        }
        return null;
    }
}

//这道题没有提供父节点的 定义，如果有父节点
方法二：从A点出发直到 root 组成一个List，从B点出发直到 root 生成另一条 List，从两条List的最后往前找最前面的共同点。
public class Solution {
    private ArrayList<TreeNode> getPath2Root(TreeNode node) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        while (node != null) {
            list.add(node);
            node = node.parent;
        }
        return list;
    }
    public TreeNode lowestCommonAncestor(TreeNode node1, TreeNode node2) {
        ArrayList<TreeNode> list1 = getPath2Root(node1);
        ArrayList<TreeNode> list2 = getPath2Root(node2);
        
        int i, j;
        for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
            if (list1.get(i) != list2.get(j)) {
                return list1.get(i).parent;
            }
        }
        return list1.get(i+1);
    }
}