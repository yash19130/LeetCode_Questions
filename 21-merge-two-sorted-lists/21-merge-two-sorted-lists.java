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
    
    public void add(int val)
    {
        ListNode node = new ListNode(val);
        if(head == null)
            head = node;
        else
            tail.next = node;
        tail = node;
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        ListNode temp1 = list1, temp2 = list2;
        while(temp1 != null && temp2 != null)
        {
            if(temp1.val < temp2.val)
            {
                add(temp1.val);
                temp1 = temp1.next;
            }
            else
            {
                add(temp2.val);
                temp2 = temp2.next;
            }
        }
        while(temp1 != null)
        {
            add(temp1.val);
            temp1 = temp1.next;
        }
        while(temp2 != null)
        {
            add(temp2.val);
            temp2 = temp2.next;
        }
        return head;
    }
}