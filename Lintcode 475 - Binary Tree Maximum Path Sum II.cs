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
        int singlePath = 0; // 从root走下来的任意node的最大路径，可以不包含任何node
        int maxPath = int.MinValue; //Tree 中任意两个点之间的最大路径，至少包含一个Node

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

            int result = maxPathSum(node1);

            Console.WriteLine(result);
        }

        static int maxPathSum(TreeNode root){
            if(root == null)
            {
                return 0;
            }

            int left = maxPathSum(root.left);
            int right = maxPathSum(root.right);

            return Math.Max(root.val, root.val + Math.Max(left, right));
        }
    }
}
