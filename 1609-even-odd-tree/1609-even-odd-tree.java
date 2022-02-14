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
    public boolean isEvenOddTree(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null)
            q.add(root);
        boolean oddLevel = false;
        while(!q.isEmpty())
        {
            int size = q.size();
            Integer prev = null;
            while(size-->0)
            {
                TreeNode node = q.poll();
                if(oddLevel)
                {
                    if(node.val % 2 != 0)
                        return false;
                    if(prev != null && node.val >= prev)
                        return false;
                }
                else
                {
                    if(node.val % 2 == 0)
                        return false;
                    if(prev != null && node.val <= prev)
                        return false;
                }
                prev = node.val;
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            oddLevel = !oddLevel;
        }
        return true;
    }
}