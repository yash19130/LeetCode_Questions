class Solution 
{
    public int maximumDetonation(int[][] bombs) 
    {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                long x0 = bombs[i][0], y0 = bombs[i][1], r0 = bombs[i][2];
                long x1 = bombs[j][0], y1 = bombs[j][1], r1 = bombs[j][2];
                long dist = (long) (Math.pow(x0-x1, 2) + Math.pow(y0-y1, 2));
                if(dist <= r0 * r0)
                    adj.get(i).add(j);
                if(dist <= r1 * r1)
                    adj.get(j).add(i);
            }
        }
        int max = 0;
        for(int i=0; i<n; i++)
            max = Math.max(max, dfs(i, adj, new boolean[n]));
        return max;
    }
    
    public int dfs(int v, List<List<Integer>> adj, boolean[] vis)
    {
        vis[v] = true;
        int calls = 0;
        for(int i: adj.get(v))
        {
            if(!vis[i])
                calls += dfs(i, adj, vis);
        }
        return 1 + calls;
    }
}