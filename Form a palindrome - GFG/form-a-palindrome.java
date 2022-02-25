// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}// } Driver Code Ends


class Solution
{
    int findMinInsertions(String s)
    {
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        return s.length() - lcs(s, rev.toString());
    }
    
    int lcs(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=n-1; i>=0; i--)
        {
            for(int j=m-1; j>=0; j--)
            {
                if(s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = 1 + dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
}