// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int TotalWays(int n)
    {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        long mod = (long) (1e9 + 7);
        for(int i=2; i<=n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        return (int) (((dp[n] % mod) * (dp[n] % mod)) % mod);
    }
}