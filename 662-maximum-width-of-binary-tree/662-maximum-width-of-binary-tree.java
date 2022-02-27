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
    static class pair
    {
        TreeNode node;
        long x;
        pair(TreeNode node, long x)
        {
            this.node = node;
            this.x = x;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) 
    {
        Queue<pair> q = new LinkedList<>();
        long width = 0;
        if(root != null)
            q.add(new pair(root, 1));
        while(!q.isEmpty())
        {
            int size = q.size();
            long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
            while(size-->0)
            {
                TreeNode node = q.peek().node;
                long x = q.peek().x;
                q.poll();
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                if(node.left != null)
                    q.add(new pair(node.left, 2*x+1));
                if(node.right != null)
                    q.add(new pair(node.right, 2*x+2));
            }
            width = Math.max(width, maxX - minX + 1);
        }
        return (int) width;
    }
}