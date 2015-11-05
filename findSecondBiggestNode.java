class findSecondBiggestNode {

        public static void main(String[] args) {
                Node root=new Node(2);
                Node n1=new Node(1);
                root.left=n1;
                Node n2=new Node(3);
                root.right=n2;
                n1.parent=root;
                n2.parent=root;
                Node n3=new Node(1.5);
                Node n4=new Node(4);
                n1.right=n3;
                n3.parent=n1;
                n2.right=n4;
                n4.parent=n2;
                Node res=secondBinaryNode(root);
                System.out.println(res.val);
        }
        public static Node secondBinaryNode(Node root){
                Node bigest=BiggestBinaryNode(root);
                Node second;$ w- h# n; _: d! t4 Y6 T! C8 h
                if(bigest.left!=null)//if root have the left child;
                        second=BiggestBinaryNode(bigest.left);
                else
                        second=bigest.parent;6 q. S0 ?. Y3 _6 U: ]
                return second;
                        //if there is no left child , we 
        }

        public static Node BiggestBinaryNode(Node root){
                while(root.right!=null)
                        root=root.right;
                return root;
        }
        
}


private static class Node{
        double val;
        Node parent;4
        Node left;
        Node right;
Node(double val){
        this.val=val;
        this.left=null;
        this.right=null;
        this.parent=null;
}

class ListNode{
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}


如果是Binary Tree，只能遍历然后sort

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        helper(root.left,  res);
        helper(root.right, res);
    }
}



//给定矩阵的
for(int i=1;i<m;i++) {
    a[0][i]+=a[0][i-1];
}
for(int i=1;i<n;i++) {
    a[i][0]+=a[i-1][0];
}
for(int i=1;i<;i++) {
   for(int j=1;j<n;j++) {
        a[i][j]+=a[i-1][j]+a[i][j-1]-a[i-1][j-1];
    }
}