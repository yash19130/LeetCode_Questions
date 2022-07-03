class Solution 
{
    public int maxResult(int[] a, int k) 
    {
        int n = a.length;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> (y[1] - x[1]));
        int[] dp = new int[n];
        dp[0] = a[0];
        pq.add(new int[]{0, dp[0]});
        for(int i=1; i<n; i++)
        {
            Integer cur = null;
            while(cur == null)
            {
                int[] p = pq.peek();
                if(p[0] < i - k)
                    pq.poll();
                else
                {
                    cur = p[1];
                    break;
                }
            }
            dp[i] = a[i] + cur;
            pq.add(new int[]{i, dp[i]});
        }
        return dp[n - 1];
    }
}