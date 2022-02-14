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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        HashMap<TreeNode, TreeNode> hp = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null)
            q.add(root);
        TreeNode temp = null;
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node.val == target.val)
            {
                temp = node;
                break;
            }
            if(node.left != null)
            {
                hp.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null)
            {
                hp.put(node.right, node);
                q.add(node.right);
            }
        }
        HashSet<TreeNode> vis = new HashSet<>();
        List<Integer> nodes = new ArrayList<>();
        solve(temp, k, nodes, hp, vis);
        return nodes;
    }
    
    public void solve(TreeNode root, int k, List<Integer> nodes, 
                        HashMap<TreeNode, TreeNode> hp, HashSet<TreeNode> vis)
    {
        if(root == null || k < 0 || vis.contains(root))
            return;
        vis.add(root);
        if(k == 0)
            nodes.add(root.val);
        if(hp.containsKey(root))
            solve(hp.get(root), k-1, nodes, hp, vis);
        solve(root.left, k-1, nodes, hp, vis);
        solve(root.right, k-1, nodes, hp, vis);
    }
}