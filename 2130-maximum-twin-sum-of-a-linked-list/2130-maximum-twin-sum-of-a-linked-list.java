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
    public ListNode reverse(ListNode head)
    {
        ListNode temp = head, prev = null, next = null;
        while(temp != null)
        {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    
    public void printList(ListNode head)
    {
        ListNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public int pairSum(ListNode head) 
    {
        int ans = Integer.MIN_VALUE;
        ListNode slow = head, fast = head.next;
        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow = head;
        while(slow != null && fast != null)
        {
            ans = Math.max(ans, slow.val + fast.val);
            slow = slow.next;
            fast = fast.next;
        }
        return ans;
    }
}