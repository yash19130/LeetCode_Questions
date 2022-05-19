class Solution 
{
    public int longestIncreasingPath(int[][] mat) 
    {
        int m = mat.length, n = mat[0].length;
        Integer[][] dp = new Integer[m][n];
        dfs(0, 0, mat, dp, -1);
        int ans = 1;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                ans = Math.max(ans, dfs(i, j, mat, dp, null));
        return ans;
    }
    
    public int dfs(int i, int j, int[][] mat, Integer[][] dp, Integer prev)
    {
        int m = mat.length, n = mat[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || (prev != null && mat[i][j] <= prev))
            return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        dp[i][j] = 1;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for(int k=0; k<4; k++)
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(i + dx[k], j + dy[k], mat, dp, mat[i][j]));
        return dp[i][j];
    }
}