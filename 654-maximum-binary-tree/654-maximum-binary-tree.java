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
    public TreeNode buildTree(int beg, int end, int[] a)
    {
        if(beg > end)
            return null;
        int maxi = beg;
        for(int i=beg+1; i<=end; i++)
            if(a[i] > a[maxi])
                maxi = i;
        TreeNode root = new TreeNode(a[maxi]);
        root.left = buildTree(beg, maxi-1, a);
        root.right = buildTree(maxi+1, end, a);
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) 
    {
        return buildTree(0, nums.length-1, nums);
    }
}