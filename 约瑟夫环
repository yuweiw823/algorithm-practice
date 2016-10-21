import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.Joseoh(6, 3);
        System.out.println(result);
    }
    
    public int Joseoh (int totalNum, int divisor){ 
        //Build the loop
        ListNode head = new ListNode(1);
        ListNode p = head;
        
        if(totalNum <= 1) {
            return 1;
        }
        
        for(int i = 2; i <= totalNum; i++) {
            ListNode newNode = new ListNode(i);
            p.next = newNode;
            p = p.next;
        }
        p.next = head;
        
        //Go loop
        while(p.next != p) {
            for(int i = 1; i < divisor; i++) {
                p = p.next;
            }
            p.next = p.next.next;
        }
        
        return p.val;
    }
};