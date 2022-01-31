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
    public int sumEvenGrandparent(TreeNode root) 
    {
        if(root == null)
            return 0;
        int l1, l2, r1, r2;
        l1 = l2 = r1 = r2 = 0;
        if(root.val % 2 == 0)
        {
            if(root.left != null)
            {
                if(root.left.left != null)
                    l1 = root.left.left.val;
                if(root.left.right != null)
                    l2 = root.left.right.val;
            }
            if(root.right != null)
            {
                if(root.right.left != null)
                    r1 = root.right.left.val;
                if(root.right.right != null)
                    r2 = root.right.right.val;
            }
        }
        return l1 + l2 + r1 + r2 + 
            sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}