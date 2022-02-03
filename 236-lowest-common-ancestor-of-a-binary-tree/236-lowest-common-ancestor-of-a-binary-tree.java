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
    static class pair
    {
        TreeNode node;
        StringBuilder path;
        pair(TreeNode node, StringBuilder path)
        {
            this.node = node;
            this.path = path;
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode a,TreeNode b) 
    {
        Queue<pair> q = new LinkedList<>();
        if(root != null)
            q.add(new pair(root, new StringBuilder()));
        StringBuilder p1 = null, p2 = null;
        while(!q.isEmpty())
        {
            pair p = q.poll();
            if(p.node.val == a.val)
                p1 = p.path;
            else if(p.node.val == b.val)
                p2 = p.path;
            if(p.node.left != null)
            {
                StringBuilder cur = new StringBuilder(p.path);
                cur.append('L');
                q.add(new pair(p.node.left, cur));
            }
            if(p.node.right != null)
            {
                StringBuilder cur = new StringBuilder(p.path);
                cur.append('R');
                q.add(new pair(p.node.right, cur));
            }
        }
        TreeNode temp = root;
        int i = 0, j = 0, n = p1.length(), m = p2.length();
        while(i < n && j < m && p1.charAt(i) == p2.charAt(j))
        {
            if(p1.charAt(i) == 'L')
                temp = temp.left;
            else
                temp = temp.right;
            i++;
            j++;
        }
        return temp;
    }
}