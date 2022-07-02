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
    public List<String> ans = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) 
    {
        rootToLeaf(root, "");
        return ans;
    }
    
    public void rootToLeaf(TreeNode root, String path)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            ans.add(new String(path + root.val + ""));
            return;
        }
        rootToLeaf(root.left, path + root.val + "->");
        rootToLeaf(root.right, path + root.val + "->");
    }
}