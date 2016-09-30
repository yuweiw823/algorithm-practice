Lintcode 007 - Serialize and Deserialize Binary Tree.java


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
//其实就是Preorder遍历
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         if(root == null) {
             return "[]";
         }
         
         StringBuffer sb = new StringBuffer("[");
         
         serializeHelper(sb, root);
         
         sb.substring(0, sb.length() - 1);  //StringBuffer 可以直接substring
         sb.append("]");
         return sb.toString();
         
    }
    
    public void serializeHelper(StringBuffer sb, TreeNode root) {
        if(root == null) {
            sb.append("#").append(",");
            return;
        } else {
            sb.append(root.val).append(",");
            serializeHelper(sb, root.left);
            serializeHelper(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]") || data.equals("[#]")) {
            return null;
        }
        
        String str = data.substring(1, data.length() - 1);  //String不能直接substring，必须指定新的object
        Queue<String> Q = new LinkedList<String>();
        Q.addAll(Arrays.asList(str.split(",")));

        TreeNode root = deserializeHelper(Q);
        return root;
    }
    
    public TreeNode deserializeHelper(Queue<String> Q) {
        String curr = Q.poll();
        if(curr.equals("#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(curr));
            node.left = deserializeHelper(Q);
            node.right = deserializeHelper(Q);
            return node;
        }
    }
}
