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
    public boolean isPalindrome(ListNode head)
    {
        int size = 0;
        ListNode temp = head;
        while (temp!=null)
        {
            size++;
            temp = temp.next;
        }
        size = size/2;
        temp = head;
        while (size-->0)
            temp = temp.next;
        ListNode node = reverse(temp);
        temp = head;
        while (node!=null && temp!=null)
        {
            if(node.val!=temp.val)
                return false;
            node = node.next;
            temp = temp.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head)
    {
        ListNode temp = head, next=null, prev=null;
        while(temp!=null)
        {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}