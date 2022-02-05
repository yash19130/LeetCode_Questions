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
    
    public void addNode(ListNode node)
    {
        if(head == null)
            head = node;
        else
            tail.next = node;
        tail = node;
    }
    
    public ListNode mergeKLists(ListNode[] lists) 
    {
        Queue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val-b.val));
        int k = lists.length;
        for(int i=0; i<k; i++)
            if(lists[i] != null)
                pq.add(lists[i]);
 
        while(!pq.isEmpty())
        {
            ListNode node = pq.remove();
            addNode(node);
            if(node.next != null)
                pq.add(node.next);
        }
        return head;
    }
}