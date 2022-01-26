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
    public void inorder(TreeNode root, List<Integer> arr)
    {
        if(root != null)
        {
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
        }
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) 
    {
        List<Integer> l1 = new LinkedList<>(), l2 = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        inorder(root1, l1);
        inorder(root2, l2);
        int i = 0, n = l1.size(), j = 0, m = l2.size();
        while(i < n && j < m)
        {
            if(l1.get(i) < l2.get(j))
                list.add(l1.get(i++));
            else
                list.add(l2.get(j++));
        }
        while(i < n)
            list.add(l1.get(i++));
        while(j < m)
            list.add(l2.get(j++));
        return list;
    }
}