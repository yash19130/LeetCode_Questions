// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}// } Driver Code Ends


class Solution
{
    public int longestPalinSubseq(String s)
    {
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        return lcs(s, rev.toString());
    }
    
    public int lcs(String s, String t)
    {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(s.charAt(i) == t.charAt(j))
                    dp[i][j] = 1 + dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}