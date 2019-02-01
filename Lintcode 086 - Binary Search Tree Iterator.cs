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

    class BSTIterator {
        private static Stack stack;
        private TreeNode curr;

        public BSTIterator(TreeNode root)
        {
            this.curr = root;
        }

        public bool hasNext(TreeNode root)
        {
            return(curr != null || stack.Count > 0);
        }

        public moveToNext (TreeNode root)
        {
            while(root != null)
            {
                stack.Push(root);
                root = root.left;
            }

            curr = stack.Pop();
            TreeNode node = curr;
            curr = curr.right;

            return node;
        }
    }
}
