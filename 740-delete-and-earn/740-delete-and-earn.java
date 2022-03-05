class Solution 
{
    public int deleteAndEarn(int[] a) 
    {
        int n = a.length;
        int[] dp = new int[10001];
        for(int i: a)
            dp[i] += i;
        dp[1] = Math.max(dp[0], dp[1]);
        for(int i=2; i<=10000; i++)
            dp[i] = Math.max(dp[i-1], dp[i-2] + dp[i]);
        return dp[10000];
    }
}