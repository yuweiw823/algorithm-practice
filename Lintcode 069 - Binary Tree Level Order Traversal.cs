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

            ArrayList result = new ArrayList();
            Queue queue = new Queue();
        }

        static ArrayList LevelOrderTraversal(ArrayList result, Queue queue, TreeNode root)
        {
            if(root == null){
                return result;
            }

            queue.Enqueue(root);

            while(queue.Count > 0)
            {
                ArrayList level = new ArrayList();
                int size = queue.Count;

                for(int i = 0; i < size; i++)
                {
                    TreeNode currNode = queue.Dequeue();
                    level.Add(currNode);

                    if(currNode.left != null)
                    {
                        queue.Enqueue(currNode.left);
                    }

                    if(currNode.right != null)
                    {
                        queue.Enqueue(currNode.right);
                    }
                }

                result.Add(level);
            }

            return result;
        }

    }
}
