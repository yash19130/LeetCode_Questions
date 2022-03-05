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
    public TreeNode deleteNode(TreeNode root, int key)
    {
        if(root == null)
            return null;
        if(root.val > key)
            root.left = deleteNode(root.left, key);
        else if(root.val < key)
            root.right = deleteNode(root.right, key);
        else
        {
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            TreeNode min = minNode(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        return root;
    }
    
    public TreeNode minNode(TreeNode root)
    {
        if(root.left == null)
            return root;
        return minNode(root.left);
    }
}