/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode head, tail;
    
    public void add(ListNode node)
    {
        if(head == null)
            head = node;
        else
            tail.next = node;
        tail = node;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode t1 = l1, t2 = l2;
        boolean carry = false;
        while(t1!=null && t2!=null)
        {
            int val = t1.val + t2.val;
            if(carry)
            {
                val++;
                carry = false;
            }
            if(val > 9)
            {
                add(new ListNode(val-10));
                carry = true;
            }
            else
                add(new ListNode(val));
            t1 = t1.next;
            t2 = t2.next;
        }
        while(t1!=null)
        {
            int val = t1.val;
            if(carry)
            {
                val++;
                carry = false;
            }
            if(val > 9)
            {
                add(new ListNode(val-10));
                carry = true;
            }
            else
                add(new ListNode(val));
            t1 = t1.next;
        }
        while(t2!=null)
        {
            int val = t2.val;
            if(carry)
            {
                val++;
                carry = false;
            }
            if(val > 9)
            {
                add(new ListNode(val-10));
                carry = true;
            }
            else
                add(new ListNode(val));
            t2 = t2.next;
        }
        if(carry)
            add(new ListNode(1));
        return head;
    }
}