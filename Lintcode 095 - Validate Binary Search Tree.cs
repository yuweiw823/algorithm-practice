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
//   2
//  / \
// 1   4
//    / \
//   3   5
//        \
//         6

            TreeNode node2 = new TreeNode(2);
            TreeNode node1 = new TreeNode(1);
            TreeNode node4 = new TreeNode(4);
            TreeNode node3 = new TreeNode(3);
            TreeNode node5 = new TreeNode(5);
            TreeNode node6 = new TreeNode(6);
        
            node2.left = node1;
            node2.right = node4;
            node4.left = node3;
            node4.right = node5;
            node5.right = node6;

            bool result = isBST(node2);
            bool result2 = isBST2(node2, minValue, maxValue);

            Console.WriteLine(result);
        }

        static int lastVal = Int16.MinValue;
        static int minValue = Int16.MinValue;
        static int maxValue = Int32.MaxValue;
        // Inorder traversal 的写法
        static bool isBST(TreeNode root){
            if(root == null)
            {
                return true;
            }

            if(!isBST(root.left)) {
                return false;
            }

            if (lastVal >= root.val)
            {
                return false;
            }
            lastVal = root.val;

            if(!isBST(root.right))
            {
                return false;
            }

           return true;
        }

        static bool isBST2(TreeNode root, int min, int max)
        {   
            if(root == null)
            {
                return true;
            }

            if(minValue >= root.val){
                return false;
            }

            if(maxValue <+ root.val){
                return false;
            }

            return isBST2(root.left, minValue, root.val) && isBST2(root.right, maxValue,root.val);
        }
    }
}
