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
            TreeNode node6 = new TreeNode(6);
        
            node1.left = node2;
            node1.right = node3;
            node2.left = node4;
            node2.right = node5;

            int result = maxDepth(node1);

            Console.WriteLine(result);
        }

        static int maxDepth(TreeNode root){
            if(root == null)
            {
                return 0;
            }

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return Math.Max(left, right) + 1;
        }
    }
}
