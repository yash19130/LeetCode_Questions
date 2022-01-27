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
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxAmount(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    int maxAmount(int a[] , int n)
    {
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
        return solve(0, n-1, a, dp);
    }
    
    int solve(int i, int j, int[] a, int[][] dp)
    {
        if(i > j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int first = a[i] + Math.min(solve(i+2, j, a, dp), solve(i+1, j-1, a, dp));
        int last = a[j] + Math.min(solve(i, j-2, a, dp), solve(i+1, j-1, a, dp));
        return dp[i][j] = Math.max(first, last);
    }
}