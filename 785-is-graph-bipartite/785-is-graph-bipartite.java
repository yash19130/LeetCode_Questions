class Solution 
{
    public boolean isBipartite(int[][] graph) 
    {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] color = new boolean[n];
        boolean bipartite = true;
        for(int i=0; i<n; i++)
        {
            if(!vis[i])
                bipartite &= dfs(i, graph, vis, true, color);
        }
        return bipartite;
    }
    
    public boolean dfs(int v, int[][] graph, boolean[] vis, boolean a, boolean[] color)
    {
        vis[v] = true;
        color[v] = a;
        boolean ans = true;
        for(int i: graph[v])
        {
            if(vis[i] && color[i] == a)
                return false;
            if(!vis[i])
                ans &= dfs(i, graph, vis, !a, color);
        }
        return ans;
    }
}