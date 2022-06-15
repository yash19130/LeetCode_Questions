class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int n = triangle.size();
        int[] dp = new int[n];
        for(int i=0; i<n; i++)
            dp[i] = triangle.get(n-1).get(i);
        for(int i=n-2; i>=0; i--)
        {
            int m = triangle.get(i).size();
            int[] cur = new int[m];
            for(int j=0; j<m; j++)
                cur[j] = Math.min(dp[j+1], dp[j]) + triangle.get(i).get(j);
            dp = cur;
        }
        return dp[0];
    }
}