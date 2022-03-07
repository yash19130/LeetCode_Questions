class Solution 
{
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        int n = graph.length;
        dfs(0, graph, new boolean[n], new ArrayList<>());
        return ans;
    }
    
    public void dfs(int v, int[][] graph, boolean[] vis, List<Integer> l)
    {
        vis[v] = true;
        l.add(v);
        if(v == graph.length-1)
            ans.add(new ArrayList<>(l));
        for(int i: graph[v])
            if(!vis[i])
                dfs(i, graph, vis, l);
        l.remove(l.size()-1);
        vis[v] = false;
    }
}