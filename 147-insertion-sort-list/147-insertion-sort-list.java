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
    public ListNode insertionSortList(ListNode head) 
    {
        ListNode node = head;
        while(node != null)
        {
            ListNode next = node, minNode = node;
            while(next != null)
            {
                if(next.val < minNode.val)
                    minNode = next;
                next = next.next;
            }
            int t = node.val;
            node.val = minNode.val;
            minNode.val = t;
            node = node.next;
        }
        return head;
    }
}