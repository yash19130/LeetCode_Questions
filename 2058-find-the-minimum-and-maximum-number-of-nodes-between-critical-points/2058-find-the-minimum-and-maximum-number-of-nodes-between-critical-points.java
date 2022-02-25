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
    public int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        if(head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};
        ListNode temp = head;
        int pos = 0;
        Integer first = null, last = null;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        while(temp.next.next != null)
        {
            int a = temp.val;
            int b = temp.next.val;
            int c = temp.next.next.val;
            if((b < a && b < c) || (b > a && b > c))
            {
                if(first == null)
                    first = pos;
                if(last != null)
                {
                    minDistance = Math.min(minDistance, pos - last);
                    maxDistance = pos - first;
                }
                last = pos;
            }
            pos++;
            temp = temp.next;
        }
        if(first == last)
            return new int[]{-1, -1};
        return new int[]{minDistance, maxDistance};
    }
}