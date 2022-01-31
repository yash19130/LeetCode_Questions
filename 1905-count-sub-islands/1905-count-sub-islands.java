class Solution 
{
    boolean isSubIsland = true;
    
    public int countSubIslands(int[][] grid1, int[][] grid2) 
    {
        int m = grid1.length, n = grid1[0].length;
        int subIslands = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid1[i][j] == 1 && grid2[i][j] == 1)
                {
                    dfs(i, j, grid1, grid2);
                    if(isSubIsland)
                        subIslands++;
                    else
                        isSubIsland = true;
                }
            }
        }
        return subIslands;
    }
    
    public void dfs(int i, int j, int[][] grid1, int[][] grid2)
    {
        int m = grid1.length, n = grid1[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] != 1)
            return;
        if(grid2[i][j] == 1 && grid1[i][j] != 1)
            isSubIsland = false;
        grid2[i][j] = -1;
        dfs(i+1, j, grid1, grid2);
        dfs(i-1, j, grid1, grid2);
        dfs(i, j+1, grid1, grid2);
        dfs(i, j-1, grid1, grid2);
    }
}