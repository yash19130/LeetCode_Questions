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
    public Map<Integer, Integer> hp = new HashMap<>();
    
    public int[] findFrequentTreeSum(TreeNode root) 
    {
        sum(root);
        int max = 0;
        for(int k: hp.keySet())
            max = Math.max(max, hp.get(k));
        List<Integer> list = new ArrayList<>();
        for(int k: hp.keySet())
            if(hp.get(k) == max)
                list.add(k);
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }
    
    public int sum(TreeNode root)
    {
        if(root == null)
            return 0;
        int cur = root.val + sum(root.left) + sum(root.right);
        hp.put(cur, hp.getOrDefault(cur, 0) + 1);
        return cur;
    }
}