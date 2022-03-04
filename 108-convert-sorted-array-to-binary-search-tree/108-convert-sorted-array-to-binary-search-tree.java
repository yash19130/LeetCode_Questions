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
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        return solve(nums, 0, nums.length-1);
    }
    
    public TreeNode solve(int[] a, int i, int j)
    {
        if(i > j)
            return null;
        int mid = (i+j)/2;
        TreeNode root = new TreeNode(a[mid]);
        root.left = solve(a, i, mid-1);
        root.right = solve(a, mid+1, j);
        return root;
    }
}