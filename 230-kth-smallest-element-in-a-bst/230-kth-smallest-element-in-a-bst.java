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
    public int ans = 0, pos = 0;
    
    public int kthSmallest(TreeNode root, int k) 
    {
        inorder(root, k);
        return ans;
    }
    
    public void inorder(TreeNode root, int k)
    {
        if(root != null)
        {
            inorder(root.left, k);
            if(++pos == k)
            {
                ans = root.val;
                return;
            }
            inorder(root.right, k);
        }
    }
}