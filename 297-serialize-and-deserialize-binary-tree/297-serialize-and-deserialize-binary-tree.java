/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec 
{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node == null)
                sb.append('N');
            else
            {
                sb.append(node.val);
                q.add(node.left);
                q.add(node.right);
            }
            sb.append(',');
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        String[] vals = data.split(",");
        boolean isLeft = true;
        TreeNode root = null, cur = null;
        for(String s: vals)
        {
            TreeNode node = null;
            if(!s.equals("N"))
            {
                node = new TreeNode(Integer.parseInt(s));
                q.add(node);
                if(root == null)
                {
                    root = cur = q.poll();
                    continue;
                }
            }
            if(cur == null)
                continue;
            if(isLeft)
            {
                isLeft = false;
                cur.left = node;
            }
            else
            {
                cur.right = node;
                cur = !q.isEmpty() ? q.poll() : null;
                isLeft = true;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));