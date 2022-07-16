class Solution 
{
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) 
    {
        return solve(startRow, startColumn, m, n, maxMove, new Integer[m][n][maxMove + 1]);
    }
    
    public int solve(int i, int j, int m, int n, int k, Integer[][][] dp)
    {
        if(i < 0 || j < 0 || i >= m || j >= n)
            return 1;
        if(k == 0)
            return 0;
        if(dp[i][j][k] != null)
            return dp[i][j][k];
        int mod = (int) (1e9 + 7);
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        dp[i][j][k] = 0;
        for(int l=0; l<4; l++)
        {
            dp[i][j][k] += solve(i + dx[l], j + dy[l], m, n, k - 1, dp) % mod;
            dp[i][j][k] %= mod;
        }
        return dp[i][j][k] % mod;
    }
}