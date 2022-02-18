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
    public ListNode reverse(ListNode n1, ListNode n2)
    {
        ListNode temp = n1, prev = null, next = null;
        while(temp != n2)
        {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        ListNode temp = head;
        ListNode n1 = null, n2 = null, prev = null, next = null;
        int pos = 1;
        while(temp != null)
        {
            if(pos == left)
                n1 = temp;
            if(pos == right)
            {
                n2 = temp.next;
            }
            if(n1 == null)
                prev = temp;
            pos++;
            temp = temp.next;
        }
        ListNode rev = reverse(n1, n2);
        if(prev == null)
        {
            n1.next = n2;
            return rev;
        }
        prev.next = rev;
        n1.next = n2;
        return head;
    }
}