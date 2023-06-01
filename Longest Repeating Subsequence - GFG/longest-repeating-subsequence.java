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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        Integer[][] dp = new Integer[str.length()][str.length()];
        return solve(0, 0, str, dp);
    }
    
    
    public int solve(int i, int j, String str, Integer[][] dp)
    {
        if(i >= str.length() || j >= str.length())
            return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        if(str.charAt(i) == str.charAt(j) && i != j)
            return dp[i][j] = 1 + solve(i + 1, j + 1, str, dp);
        return dp[i][j] = Math.max(solve(i + 1, j, str, dp), solve(i, j + 1, str, dp));
    }
}