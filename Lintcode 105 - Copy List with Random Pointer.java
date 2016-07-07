Lintcode 105 - Copy List with Random Pointer
http://www.lintcode.com/en/problem/copy-list-with-random-pointer/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    //其实就是连着指针一起复制 
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
                //original Node, copied Node
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0); //used to return the copied list
        RandomListNode pre = dummy;//used to return the original list
        RandomListNode p;  //pointer used to move and link
        if(head == null) {
            return head;
        }
        
        while(head != null) {
            if(map.containsKey(head)) {
                p = map.get(head);
            } else {
                p = new RandomListNode(head.label);
                map.put(head, p);
            }
            pre.next = p;
            
            if(head.random != null) {
                if(map.containsKey(head.random)) {
                    p.random = map.get(head.random);
                } else {
                    p.random = new RandomListNode(head.random.label);
                    map.put(head.random, p.random);
                }
            }
            
            pre = p; // p 用来生成新的node，pre用来在新的list上前进，hold住之前生成的一个Node
            head = head.next;  //head 在原list上前进
            
        }
        
        return dummy.next;
        
    }
}