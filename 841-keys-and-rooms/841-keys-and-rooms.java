class Solution 
{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        dfs(0, rooms, vis);
        for(int i=0; i<n; i++)
            if(!vis[i])
                return false;
        return true;
    }
    
    public void dfs(int v, List<List<Integer>> rooms, boolean[] vis)
    {
        vis[v] = true;
        for(int i: rooms.get(v))
            if(!vis[i])
                dfs(i, rooms, vis);
    }
}