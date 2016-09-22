Leetcode 138 - Copy List with Random Pointer.java


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode oldNode = head;
        while(oldNode != null) {
            RandomListNode newNode = new RandomListNode(oldNode.label);
            map.put(oldNode, newNode);
            oldNode = oldNode.next;
        }
        
        RandomListNode dummy = map.get(head);
        RandomListNode newNode = map.get(head);
        while(head != null) {
            newNode.next = map.get(head.next);
            if(head.random != null) {
                newNode.random = map.get(head.random);
            }
            head = head.next;
            newNode = newNode.next;
        }
        
        return dummy;
    }
}