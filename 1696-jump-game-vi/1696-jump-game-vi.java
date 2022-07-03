class Solution 
{
    public int maxResult(int[] a, int k) 
    {
        int n = a.length;
        TreeMap<Integer, Integer> hp = new TreeMap<>();
        int[] dp = new int[n];
        dp[0] = a[0];
        hp.put(dp[0], 1);
        for(int i=1; i<n; i++)
        {
            dp[i] = a[i] + hp.lastKey();
            if(i - k >= 0)
            {
                hp.put(dp[i - k], hp.get(dp[i - k]) - 1);
                if(hp.get(dp[i - k]) == 0)
                    hp.remove(dp[i - k]);
            }
            hp.put(dp[i], hp.getOrDefault(dp[i], 0) + 1);
        }
        return dp[n - 1];
    }
}