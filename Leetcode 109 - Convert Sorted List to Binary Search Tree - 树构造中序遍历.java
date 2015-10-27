//Leetcode 109 - Convert Sorted List to Binary Search Tree - 中序遍历.java

// 使用一个ArrayList储存ListNode，相当于转化成数组(108题)，然后中序遍历。
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        int count = 0; //得到整个ListNode的长度1
        while(p!= null){
            p = p.next;
            count++;   //count is the length of the Linked List
        }
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        return helper(list, 0, count-1);
    }
    
    public TreeNode helper(List<ListNode> list, int l, int r){
        if(l>r) return null;
        int m = (l+r)/2;
    // 先建左子树
        TreeNode left = helper(list, l, m-1);
    // 再创建root，把左子树连到root上
        TreeNode root = new TreeNode(list.get(0).val);
        root.left = left;
    //root 已经用掉了，拿出下一个点
        list.set(0,list.get(0).next); 
    //再建右子树，直接连到root上
        root.right = helper(list, m+1, r);
        return root;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {x = val;}
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}