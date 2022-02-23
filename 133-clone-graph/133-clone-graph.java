/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution 
{
    public void dfs(Node v, Node cur, Node[] vis)
    {
        vis[cur.val] = cur;
        for(Node n: v.neighbors)
        {
            if(vis[n.val] == null)
            {
                Node node = new Node(n.val);
                dfs(n, node, vis);
                cur.neighbors.add(node);
            }
            else
                cur.neighbors.add(vis[n.val]);
        }
    }
    
    public Node cloneGraph(Node node) 
    {
        if(node == null)
            return null;
        Node[] vis = new Node[101];
        Node ans = new Node(node.val);
        dfs(node, ans, vis);
        return ans;
    }
}