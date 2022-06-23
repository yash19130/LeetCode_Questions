class Solution 
{
    public int minDistance(String s1, String s2) 
    {
        int n = s1.length(), m = s2.length();
        Integer[][] dp = new Integer[n][m];
        return solve(0, 0, s1, s2, dp);
    }
    
    public int solve(int i, int j, String s1, String s2, Integer[][] dp)
    {
        int n = s1.length(), m = s2.length();
        if(i == n)
            return m - j;
        if(j == m)
            return n - i;
        if(dp[i][j] != null)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = solve(i + 1, j + 1, s1, s2, dp);
        return dp[i][j] = 1 + Math.min(solve(i + 1, j + 1, s1, s2, dp), 
                        Math.min(solve(i + 1, j, s1, s2, dp), solve(i, j + 1, s1, s2, dp)));
    }
}