class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int n = cost.length;
        if(n==1)
            return cost[0];
        int[] dp = new int[n+2];
        for(int i=n-1; i>=0; i--)
            dp[i] = Math.min(dp[i+1], dp[i+2]) + cost[i];
        return Math.min(dp[0], dp[1]);
    }
}