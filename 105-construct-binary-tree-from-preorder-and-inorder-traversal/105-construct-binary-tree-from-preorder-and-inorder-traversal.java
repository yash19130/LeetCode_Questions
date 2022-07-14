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
    int index = 0;
    
    public int find(int e, int[] inorder, int i, int j)
    {
        for(int k=i; k<=j; k++)
            if(inorder[k] == e)
                return k;
        return -1;
    }
    
    public TreeNode build(int i, int j, int[] preorder, int[] inorder)
    {
        if(i > j || index >= preorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[index]);
        int pos = find(preorder[index++], inorder, i, j);
        root.left = build(i, pos-1, preorder, inorder);
        root.right = build(pos+1, j, preorder, inorder);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        return build(0, preorder.length, preorder, inorder);
    }
}