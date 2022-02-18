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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public TreeNode toBST(ListNode head, int beg, int end)
    {
        if(beg > end)
            return null;
        int mid = (beg + end)/2;
        int pos = beg;
        ListNode middle = head;
        while(pos != mid)
        {
            pos++;
            middle = middle.next;
        }
        TreeNode root = new TreeNode(middle.val);
        root.left = toBST(head, beg, mid-1);
        root.right = toBST(middle.next, mid+1, end);
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) 
    {
        int size = 0;
        ListNode temp = head;
        while(temp != null)
        {
            size++;
            temp = temp.next;
        }
        return toBST(head, 1, size);
    }
}