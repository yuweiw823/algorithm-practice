Al problems - LowestCommonAncestor.java

public class LowestCommonAncestorBT {
	public Node getLCA(Node root, Node n1, Node n2){
		if(root==null) return null;
		if(root.data==n1.data||root.data==n2.data) return root;

		Node left = getLCA(root.left,n1,n2);
		Node right = getLCA(root.right,n1,n2);

		if(left!=null && right!=null) return root;
		if(left!=null) return left;
		else if(right!=null) return right;
		return null;
	}
}