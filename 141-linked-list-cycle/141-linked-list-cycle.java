/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public boolean hasCycle(ListNode head) 
    {
        if(head==null)
            return false;
        ListNode hare = head, tor = head;
        while(hare!=null && hare.next!=null)
        {
            tor = tor.next;
            hare = hare.next.next;
            if(tor == hare)
                return true;
        }
        return false;
    }
}