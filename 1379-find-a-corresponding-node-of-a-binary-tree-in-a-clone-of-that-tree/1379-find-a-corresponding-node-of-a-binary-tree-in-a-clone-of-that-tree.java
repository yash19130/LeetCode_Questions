/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution 
{
    public final TreeNode getTargetCopy(final TreeNode original, 
                        final TreeNode cloned, final TreeNode target) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        if(cloned != null)
            q.add(cloned);
        TreeNode node = null;
        while(!q.isEmpty())
        {
            node = q.poll();
            if(node.val == target.val)
                return node;
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
        return node;
    }
}