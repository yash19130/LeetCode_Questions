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
    List<List<Integer>> ans = new ArrayList<>();      
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        solve(root, targetSum, 0, new ArrayList<>());
        return ans;
    }
    
    public void solve(TreeNode root, int target, int sum, List<Integer> cur)
    {
        if(root==null)
            return;
        List<Integer> arr = new ArrayList<>(cur);
        arr.add(root.val);
        if(sum + root.val == target && root.left==null && root.right==null)
            ans.add(arr);
        solve(root.left, target, sum+root.val, arr);
        solve(root.right, target, sum+root.val, arr);
    }
}