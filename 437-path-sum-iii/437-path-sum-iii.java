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
    public int ans = 0;
    
    public int pathSum(TreeNode root, int targetSum) 
    {
        if(root != null)
        {
            pathSum(root.left, targetSum);
            solve(root, 0, targetSum);
            pathSum(root.right, targetSum);
        }
        return ans;
    }
    
    public void solve(TreeNode root, int cur, int sum)
    {
        if(root == null)
            return;
        if(cur + root.val == sum)
            ans++;
        solve(root.left, cur + root.val, sum);
        solve(root.right, cur + root.val, sum);
    }
}