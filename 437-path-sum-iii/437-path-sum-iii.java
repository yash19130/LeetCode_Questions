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
        Map<Integer, Integer> hp = new HashMap<>();
        hp.put(0, 1);
        solve(root, 0, targetSum, hp);
        return ans;
    }
    
    public void solve(TreeNode root, int sum, int target, Map<Integer, Integer> hp)
    {
        if(root == null)
            return;
        sum += root.val;
        ans += hp.getOrDefault(sum - target, 0);
        hp.put(sum, hp.getOrDefault(sum, 0) + 1);
        solve(root.left, sum, target, hp);
        solve(root.right, sum, target, hp);
        hp.put(sum, hp.getOrDefault(sum, 0) - 1);
        sum -= root.val;
    }
}