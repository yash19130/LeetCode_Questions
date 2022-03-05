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
    public TreeNode deleteNode(TreeNode root, int X) 
    {
        if(root == null){
            return null;
        }
        else if(X < root.val){
            root.left = deleteNode(root.left, X);
        }
        else if(X > root.val){
            root.right = deleteNode(root.right, X);
        }
        else{
            //Case 1 : Leaf node
            if(root.left == null && root.right == null){
                root = null;
            }
            //Case 2 : One child
            else if(root.left == null){
                TreeNode temp = root;
                root = root.right;
                temp = null;
            }
            else if(root.right == null){
                TreeNode temp = root;
                root = root.left;
                temp = null;
            }
            //Case 3 : 2 child
            else{
                //Finding minimum Node in right subtree
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                //Deleting the duplicate node from the BT
                root.right = deleteNode(root.right, temp.val);
            }
        }
        return root;
    }
    
    TreeNode findMin(TreeNode root)
    {
        if(root==null || root.left==null)
            return root;
        return findMin(root.left);
    }
}