class Solution 
{
    public int maxIncreaseKeepingSkyline(int[][] grid) 
    {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];
        for(int i=0; i<n; i++)
        {
            int curRowMax = grid[i][0];
            for(int j=1; j<n; j++)
                curRowMax = Math.max(curRowMax, grid[i][j]);
            rowMax[i] = curRowMax;
        }
        for(int j=0; j<n; j++)
        {
            int curColMax = grid[0][j];
            for(int i=1; i<n; i++)
                curColMax = Math.max(curColMax, grid[i][j]);
            colMax[j] = curColMax;
        }
        int ans = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
        return ans;
    }
}