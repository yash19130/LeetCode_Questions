/**
 * Definition for singly-linked list.
 * public class ListNode {
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
    public int size(ListNode head)
    {
        ListNode temp = head;
        int s = 0;
        while(temp!=null)
        {
            s++;
            temp = temp.next;
        }
        return s;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        int s1 = size(headA), s2 = size(headB);
        int s = Math.abs(s1-s2);
        ListNode temp1 = headA, temp2 = headB;
        if(s1 > s2)
        {
            for(int i=1; i<=s; i++)
                temp1 = temp1.next;
        }
        else
        {
            for(int i=1; i<=s; i++)
                temp2 = temp2.next;
        }
        while(temp1 != null && temp2 != null)
        {
            if(temp1 == temp2)
                return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}