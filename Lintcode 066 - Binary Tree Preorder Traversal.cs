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
            ArrayList result = new ArrayList();
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);
        
            node1.left = node2;
            node1.right = node3;
            node2.left = node4;
            node2.right = node5;

            DFS(result, node1);

            foreach(int i in result)
            {
                Console.WriteLine(i);
            }
        }

        static void DFS(ArrayList result, TreeNode root)
        {
            if(root == null)
            {
                return;
            }

            result.Add(root.val);

            DFS(result, root.left);
            DFS(result, root.right);
        }


        static void preorderBinaryTree(TreeNode root, Stack stack, ArrayList result){
            if(root == null)
            {
                return;
            }

            while(root != null || stack.Count > 0){
                if(root != null){
                    result.Add(root.val);
                    stack.Push(root);
                    root = root.left;
                } else {
                    root = stack.Pop();
                    root = root.right;
                }
            }
        }
    }
}
