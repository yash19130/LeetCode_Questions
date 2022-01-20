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
    Integer leftMost;
    
    public int height(TreeNode root)
    {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public int findBottomLeftValue(TreeNode root) 
    {
        int h = height(root);
        levelOrder(root, h);
        return leftMost;
    }
    
    public void levelOrder(TreeNode root, int level)
    {
        if(root == null || level < 1)
            return;
        if(level == 1)
        {
            if(leftMost == null)
                leftMost = root.val;
            return;
        }
        levelOrder(root.left, level-1);
        levelOrder(root.right, level-1);
    }
}