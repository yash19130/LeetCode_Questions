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
        int level, column;
        pair(TreeNode node, int level, int column)
        {
            this.node = node;
            this.level = level;
            this.column = column;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        TreeMap<Integer, List<pair>> tp = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        if(root != null)
            q.add(new pair(root, 0, 0));
        while(!q.isEmpty())
        {
            pair p = q.poll();
            TreeNode node = p.node;
            int level = p.level;
            int column = p.column;
            if(tp.containsKey(column))
                tp.get(column).add(p);
            else
            {
                List<pair> list = new ArrayList<>();
                list.add(p);
                tp.put(column, list);
            }
            if(node.left != null)
                q.add(new pair(node.left, level+1, column-1));
            if(node.right != null)
                q.add(new pair(node.right, level+1, column+1));
        }
        List<List<Integer>> traversal = new ArrayList<>();
        for(int l: tp.keySet())
        {
            List<Integer> cur = new ArrayList<>();
            Collections.sort(tp.get(l), new Comparator<pair>()
            {
                @Override
                public int compare(pair p1, pair p2)
                {
                    if(p1.level == p2.level)
                        return p1.node.val - p2.node.val;
                    return p1.level - p2.level;
                }
            });
            for(pair p: tp.get(l))
                cur.add(p.node.val);
            traversal.add(cur);
        }
        return traversal;    
    }
}