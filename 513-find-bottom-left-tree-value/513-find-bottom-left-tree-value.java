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
    public int findBottomLeftValue(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null)
            q.add(root);
        TreeNode left = root;
        while(!q.isEmpty())
        {
            int size = q.size();
            boolean isLeftMost = true;
            while(size-->0)
            {
                TreeNode node = q.poll();
                if(isLeftMost)
                {
                    left = node;
                    isLeftMost = false;
                }
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
        }
        return left.val;
    }
}