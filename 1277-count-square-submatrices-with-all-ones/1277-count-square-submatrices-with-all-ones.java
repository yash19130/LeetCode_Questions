class Solution 
{
    public int countSquares(int[][] mat) 
    {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int count = 0;
        for(int i=m-1; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(mat[i][j] == 1)
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                count += dp[i][j];
            }
        }
        return count;
    }
}