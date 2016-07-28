Lintcode 129 - Rehashing.java

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if(hashTable == null || hashTable.length == 0) {
            return null;
        }
        
        int newCapacity = 2 * hashTable.length;
        ListNode[] newHashTable = new ListNode[newCapacity];
        
        for (int i = 0; i < hashTable.length; i++) {
            while(hashTable[i] != null) {
                int newIdx = (hashTable[i].val % newCapacity + newCapacity) % newCapacity;
                if(newHashTable[newIdx] == null) {
                    newHashTable[newIdx] = new ListNode(hashTable[i].val);
                } else {
                    ListNode head = newHashTable[newIdx];
                    while(head.next != null) {
                        head = head.next;
                    }
                    head.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        
        return newHashTable;
    }
};
