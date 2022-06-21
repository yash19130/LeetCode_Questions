class Solution 
{
    public int minInsertions(String s) 
    {
        int n = s.length();
        StringBuilder rev = new StringBuilder(s);
        return n - lcs(s, rev.reverse().toString());
    }
    
    public int lcs(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i=n-1; i>=0; i--)
        {
            for(int j=m-1; j>=0; j--)
            {
                if(s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}