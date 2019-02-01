using System;
using System.Collections;

namespace CSharp
{
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int val)
        {
            this.val = val;
            this.left = this.right = null;
        }
    }
    class Program
    {

        static void Main(string[] args)
        {

            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);
        
            node1.left = node2;
            node1.right = node3;
            node2.left = node4;
            node2.right = node5;

            TreeNode LCANode = LCA(node1, node4, node3);
        }

        static TreeNode LCA(TreeNode root, TreeNode A, TreeNode B)
        {
            if(root == null || A == null || B == null)
            {
                return root;
            };

            TreeNode leftLCA = LCA(root.left, A, B);
            TreeNode rightLCA = LCA(root.right, A, B);

            if(leftLCA != null && rightLCA != null)
            {
                return root;
            }

            if(leftLCA != null)
            {
                return root.left;
            }

            if(rightLCA != null)
            {
                return root.right;
            }

            return  null;
        }


    }
}
