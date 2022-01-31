class Solution 
{
    public int[][] findFarmland(int[][] land) 
    {
        ArrayList<int[]> arr = new ArrayList<>();
        int m = land.length, n = land[0].length;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(land[i][j] == 1)
                    arr.add(bfs(i, j, m, n, land));
        
        int[][] ans = new int[arr.size()][4];
        for(int i=0; i<arr.size(); i++)
            ans[i] = arr.get(i);
        return ans;
    }
    
    public int[] bfs(int i, int j, int m, int n, int[][] land)
    {
        Queue<int[]> q = new LinkedList<>();
        int[] p = new int[2];
        q.add(new int[]{i, j});
        land[i][j] = -1;
        while(!q.isEmpty())
        {
            p = q.poll();
            int x = p[0], y = p[1];
            if(y + 1 < n && land[x][y+1] == 1)
            {
                land[x][y+1] = -1;
                q.add(new int[]{x, y+1});
            }
            if(x + 1 < m && land[x+1][y] == 1)
            {
                land[x+1][y] = -1;
                q.add(new int[]{x+1, y});
            }
        }
        return new int[]{i, j, p[0], p[1]};
    }
}