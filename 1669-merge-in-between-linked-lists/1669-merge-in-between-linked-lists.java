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
    public ListNode mergeInBetween(ListNode list1, int a, 
                                   int b, ListNode list2) 
    {
        ListNode first = list1;
        int pos = 1;
        while(pos < a)
        {
            first = first.next;
            pos++;
        }
        ListNode second = first;
        while(pos <= b)
        {
            second = second.next;
            pos++;
        }
        second = second.next;
        first.next = list2;
        ListNode temp = list2;
        while(temp.next != null)
            temp = temp.next;
        temp.next = second;
        return list1;
    }
}