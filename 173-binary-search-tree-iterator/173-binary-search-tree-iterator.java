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
class BSTIterator 
{
    Queue<Integer> q;
    
    public BSTIterator(TreeNode root) 
    {
        this.q = new LinkedList<>();
        q.add(0);
        inorder(root, q);
    }
    
    public void inorder(TreeNode root, Queue<Integer> q)
    {
        if(root != null)
        {
            inorder(root.left, q);
            q.add(root.val);
            inorder(root.right, q);
        }
    }
    
    public int next() 
    {
        q.poll();
        return q.peek();
    }
    
    public boolean hasNext() 
    {
        return q.size() > 1;    
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */