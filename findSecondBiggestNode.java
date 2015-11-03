class findSecondBiggestNode {
        private static class Node{
                double val;$ E! e* B! K4 m0 M
                Node parent;4 u( _* W% B2 b) I
                Node left;
                Node right;* c% k9 R8 F% I
        Node(double val){
                this.val=val;. Y5 Q! u# o9 E/ M0 r- t! s) i
                this.left=null;! {4 c! }, v6 \/ N2 S9 b9 ^+ p. e. x
                this.right=null;: h9 {" S, P8 ]
                this.parent=null;
        }3 q0 K# L2 f. ?8 r
        }
        public static void main(String[] args) {
                Node root=new Node(2);
                Node n1=new Node(1);
                root.left=n1;4 F0 i& u' U$ J+ q+ o# K0 S
                Node n2=new Node(3);
                root.right=n2;
                n1.parent=root;
                n2.parent=root;3 q6 c& E: o7 d( Q- B9 e% i
                Node n3=new Node(1.5);6 Z0 @+ W% ?8 E! z7 e1 f
                Node n4=new Node(4);# v3 x' u2 N7 M2 ?8 l" E+ ?; C
                n1.right=n3;
                n3.parent=n1;) i- k; e; R% E, _
                n2.right=n4;
                n4.parent=n2;1 ?5 R$ A5 a. V4 L3 i
                Node res=secondBinaryNode(root);
                System.out.println(res.val);, V6 W* ?- V, @$ Q
        }4 G5 b3 `$ A' ]9 H6 F. v
        public static Node secondBinaryNode(Node root){
                Node bigest=BiggestBinaryNode(root);
                Node second;$ w- h# n; _: d! t4 Y6 T! C8 h
                if(bigest.left!=null)//if root have the left child;
                        second=BiggestBinaryNode(bigest.left);
                else# q1 Y4 B) z% B+ m
                        second=bigest.parent;6 q. S0 ?. Y3 _6 U: ]
                return second;
                        //if there is no left child , we 
        }4 C- y. E$ O) ?4 o& a2 M/ `
        / |9 k3 m; t4 y! a4 v
        public static Node BiggestBinaryNode(Node root){
                while(root.right!=null)5 N1 X+ |6 R4 A' e1 g/ W
                        root=root.right;
                return root;
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