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
class Solution {
	/**
	 * This method will be invoked first, you should design your own algorithm 
	 * to serialize a binary tree which denote by a root node to a string which
	 * can be easily deserialized by your own "deserialize" method later.
	 */
	public String serialize(TreeNode root) {
		// write your code here
		if(root == null) {
			return "{}";
		}
		
		
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		Q.offer(root);
		
		//第一步先把所有的Node依序加入。
		//实际上不需要这个Queue，直接for循环， i < ArrayList.size()即可实现同样的效果。
		while(!Q.isEmpty()) {
			TreeNode curr = Q.poll();
			nodeList.add(curr);
			if(curr == null) {
				continue;
			}
			Q.offer(curr.left);
			Q.offer(curr.right);
		}
		
		while(nodeList.get(nodeList.size() - 1) == null) {
			nodeList.remove(nodeList.size() - 1);
		}
		
		StringBuffer sb = new StringBuffer("{");
		
		for(int i = 0; i < nodeList.size(); i++) {
			if(nodeList.get(i) == null) {
				sb.append("#");
			} else {
				sb.append(nodeList.get(i).val);
			}
			sb.append(",");
		}
		
		sb.substring(0, sb.length() - 1);
		sb.append("}");
		
		return sb.toString();
	}
	
	/**
	 * This method will be invoked second, the argument data is what exactly
	 * you serialized at method "serialize", that means the data is not given by
	 * system, it's given by your own serialize method. So the format of data is
	 * designed by yourself, and deserialize it here as you serialize it in 
	 * "serialize" method.
	 */
	public TreeNode deserialize(String data) {
		// write your code here
		if(data == null || data.equals("{}")) {
			return null;
		}
		
		String nodeStr = data.substring(1, data.length() - 1);

		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		String[] nodes = nodeStr.split(",");

		TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
		Q.offer(root);
		int i = 0;
		while(!Q.isEmpty()) {
			TreeNode curr = Q.poll();
			i++;
			if(i < nodes.length && !nodes[i].equals("#")) {
				TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
				curr.left = left;
				Q.offer(left);
			} else {
				curr.left = null;
			}

			i++;
			if(i < nodes.length && !nodes[i].equals("#")) {
				TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
				curr.right = right;
				Q.offer(right);
			} else {
				curr.right = null;
			}
		}
		return root;
	}
}
