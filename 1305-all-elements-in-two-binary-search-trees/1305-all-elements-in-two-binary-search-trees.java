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
    public void inorder(TreeNode root, Queue<Integer> q)
    {
        if(root != null)
        {
            inorder(root.left, q);
            q.add(root.val);
            inorder(root.right, q);
        }
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) 
    {
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        inorder(root1, q1);
        inorder(root2, q2);
        while(!q1.isEmpty() && !q2.isEmpty())
        {
            if(q1.peek() < q2.peek())
                list.add(q1.poll());
            else
                list.add(q2.poll());
        }
        while(!q1.isEmpty())
            list.add(q1.poll());
        while(!q2.isEmpty())
            list.add(q2.poll());
        return list;
    }
}