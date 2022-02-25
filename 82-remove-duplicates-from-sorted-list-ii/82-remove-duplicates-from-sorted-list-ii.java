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
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
        ListNode sentinel = new ListNode(0);
        ListNode zero = sentinel, cur = head;
        while(cur != null)
        {
            ListNode next = cur.next;
            if(next == null || cur.val != next.val)
            {
                zero.next = cur;
                zero = zero.next;
            }
            else
            {
                while(next != null && cur.val == next.val)
                    next = next.next;
            }
            cur = next;
        }
        zero.next = null;
        return sentinel.next;
    }
}