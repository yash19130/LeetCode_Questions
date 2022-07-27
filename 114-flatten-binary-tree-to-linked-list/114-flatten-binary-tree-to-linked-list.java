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
    public void flatten(TreeNode root) 
    {
        if(root == null)
            return;
        TreeNode r = root.right;
        root.right = root.left;
        TreeNode temp = root.left;
        root.left = null;
        while(temp != null && temp.right != null)
            temp = temp.right;
        if(temp != null)
            temp.right = r;
        else
            root.right = r;
        flatten(root.right);
    }
}