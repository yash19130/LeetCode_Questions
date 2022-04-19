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
    public void inorder(TreeNode root, List<TreeNode> a)
    {
        if(root!=null)
        {
            inorder(root.left, a);
            a.add(root);
            inorder(root.right, a);
        }
    }
   
    public void recoverTree(TreeNode root)
    {
        List<TreeNode> a1 = new ArrayList<>();
        List<TreeNode> a2 = new ArrayList<>();
        inorder(root, a1);
        inorder(root, a2);
        TreeNode n1 = null, n2 = null;
        for(int i=0; i<a1.size()-1; i++)
        {
            if(a1.get(i).val > a1.get(i+1).val)
            {
                n1 = a1.get(i);
                break;
            }
        }
        for(int i=a2.size()-1; i>=1; i--)
        {
            if(a2.get(i).val < a2.get(i-1).val)
            {
                n2 = a2.get(i);
                break;
            }
        }
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}