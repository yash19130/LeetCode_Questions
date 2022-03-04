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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> zigzag = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null)
            q.add(root);
        boolean order = true;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while(size-->0)
            {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            if(!order)
                Collections.reverse(level);
            zigzag.add(level);
            order = !order;
        }
        return zigzag;
    }
}