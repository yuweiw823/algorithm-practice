using System;
using System.Collections;

namespace CSharp
{
    public class ListNode
    {
        public int val;
        public ListNode next;

        public ListNode(int val)
        {
            this.val = val;
        }
    }
    class Program{
        static void Main()
        {
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(3);
            ListNode node5 = new ListNode(4);
            ListNode node6 = new ListNode(5);
            ListNode node7 = new ListNode(3);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node6;
            node6.next = node7;

            ListNode result = middleNode(node1);
            Console.WriteLine(result.val);

        }

        static ListNode middleNode(ListNode head)
        {
            if(head == null || head.next == null)
            {
                return head;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while(fast != null && fast.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }

}
