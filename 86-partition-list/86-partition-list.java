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
    public ListNode partition(ListNode head, int x) 
    {
        ListNode lessThanX = new ListNode(0);
        ListNode moreThanX = new ListNode(0);
        ListNode a = lessThanX, b = moreThanX;
        ListNode temp = head;
        while(temp != null)
        {
            ListNode node = new ListNode(temp.val);
            if(temp.val < x)
            {
                a.next = node;
                a = node;
            }
            else
            {
                b.next = node;
                b = node;
            }
            temp = temp.next;
        }
        a.next = moreThanX.next;
        return lessThanX.next;
    }
}