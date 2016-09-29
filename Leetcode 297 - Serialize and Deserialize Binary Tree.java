Leetcode 297 - Serialize and Deserialize Binary Tree.java


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//BFS的解法
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         if(root == null) {
             return "[]";
         }
         
         StringBuffer result = new StringBuffer("[");
         Queue<TreeNode> Q = new LinkedList<TreeNode>();
         Q.offer(root);
         
         while(!Q.isEmpty()) {
             TreeNode curr = Q.poll();
             if(curr == null) {
                 result.append("#");
             } else {
                 result.append(curr.val);
                 Q.offer(curr.left);
                 Q.offer(curr.right);
             }
             result.append(",");
         }
         
         result.substring(0, result.length() - 1);
         result.append("]");
         
         return result.toString();
         
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]") || data.equals("[#]")) {
            return null;
        }
        
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        
        
        int i = 1;
        while(i < nodes.length) {
            TreeNode curr = Q.poll();
            
            if(!nodes[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                curr.left = left;
                Q.offer(left);
            }
            i++;

            if(!nodes[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                curr.right = right;
                Q.offer(right);
            }
            i++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


//DFS的解法

https://discuss.leetcode.com/topic/28029/easy-to-understand-java-solution