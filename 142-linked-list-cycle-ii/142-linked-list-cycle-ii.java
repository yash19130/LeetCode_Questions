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
    public ListNode detectCycle(ListNode head) 
    {
        if(head==null)
            return null;
        ListNode hare = head, tor = head;
        while(hare!=null && hare.next!=null)
        {
            tor = tor.next;
            hare = hare.next.next;
            if(tor == hare)
                break;
        }
        if(hare==null || hare.next==null)
            return null;
        tor = head;
        while(tor!=hare)
        {
            tor = tor.next;
            hare = hare.next;
        }
        return tor;
    }
}