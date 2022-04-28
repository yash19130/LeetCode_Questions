class Solution 
{
    public int minimumEffortPath(int[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int beg = 0, end = 0;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                end = Math.max(end, grid[i][j]);
        int minDif = end;
        while(beg <= end)
        {
            int mid = beg + (end - beg) / 2;
            if(dfs(0, 0, grid, mid, null, new boolean[m][n]))
            {
                minDif = mid;
                end = mid - 1;
            }
            else
                beg = mid + 1;
        }
        return minDif;
    }
    
    public boolean dfs(int i, int j, int[][] grid, int dif, Integer last, boolean[][] vis)
    {
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || vis[i][j])
            return false;
        if(last != null && Math.abs(last - grid[i][j]) > dif)
            return false;
        if(i == m-1 && j == n-1)
            return true;
        vis[i][j] = true;
        boolean right = dfs(i + 1, j, grid, dif, grid[i][j], vis);
        boolean left = dfs(i - 1, j, grid, dif, grid[i][j], vis);
        boolean down = dfs(i, j + 1, grid, dif, grid[i][j], vis);
        boolean up = dfs(i, j - 1, grid, dif, grid[i][j], vis);
        return right || left || down || up;
    }
}