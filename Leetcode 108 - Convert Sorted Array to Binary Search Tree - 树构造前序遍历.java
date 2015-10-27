// Leetcode 108 - Convert Sorted Array to Binary Search Tree - 树的构造最基本.java

// 108 - 最简单的 Convert Sorted Array to Binary Search Tree，数组本身是有序的，那么我们知道每次只要取中点作为根，然后递归构建对应的左右子树就可以了，递归的写法跟常规稍有不同，就是要把根root先new出来，然后它的左节点接到递归左边部分的返回值，右节点接到递归右边部分的返回值，最后将root返回回去。这个模板在树的构造中非常有用，其他几道题也都是按照这个来实现。

// 时间复杂度还是一次树遍历O(n)，总的空间复杂度是栈空间O(logn)加上结果的空间O(n)，额外空间是O(logn)，总体是O(n)。代码如下：

public class Solution{
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        TreeNode root = buildBiTree(nums);
        
    }
  
    public static TreeNode buildBiTree(int[] nums){
        if(nums.length == 0 || nums == null) return null;
        TreeNode root = helper(nums, 0, nums.length-1);
        return root;
    }
  
    public static TreeNode helper(int[] nums, int l, int r){
        if(l>r) return null;
        int m = (l+r)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums, l, m-1);  //左边整个子树的node，都把root.left作为root
        root.right = helper(nums, m+1, r); //右边整个子树的node，都把root.right作为root
        return root;
    }
  
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {x = val;}
    }
}
