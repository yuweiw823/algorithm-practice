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
            
            int removeVal = 3;

            ListNode dummy = new ListNode(0);
            dummy.next = node1;

            ListNode p = dummy;
            while(p.next != null)
            {
                if(p.next.val == removeVal)
                {
                    p.next = p.next.next;
                }
                else
                {
                    p = p.next;
                }
            }
        }
    }

}
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
            
            int removeVal = 3;

            ListNode dummy = new ListNode(0);
            dummy.next = node1;

            ListNode p = dummy;
            while(p.next != null)
            {
                if(p.next.val == removeVal)
                {
                    p.next = p.next.next;
                }
                else
                {
                    p = p.next;
                }
            }
        }
    }

}
