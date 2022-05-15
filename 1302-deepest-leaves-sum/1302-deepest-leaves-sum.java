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
    public int sum = 0;
    public void levelOrder(TreeNode root, int level)
    {
        if(root==null || level<1)
            return;
        if(level==1)
            sum += root.val;
        levelOrder(root.left, level-1);
        levelOrder(root.right, level-1);
    }
    
    public int height(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public int deepestLeavesSum(TreeNode root) 
    {
        int h = height(root);
        levelOrder(root, h);
        return sum;
    }
}