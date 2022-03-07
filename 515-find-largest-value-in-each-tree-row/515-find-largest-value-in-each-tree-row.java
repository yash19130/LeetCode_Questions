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
    public List<Integer> largestValues(TreeNode root) 
    {
        List<Integer> levelMax = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null)
            q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            int curMax = Integer.MIN_VALUE;
            while(size-->0)
            {
                TreeNode node = q.poll();
                curMax = Math.max(curMax, node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            levelMax.add(curMax);
        }
        return levelMax;    
    }
}