// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}// } Driver Code Ends



class solve
{
    static long countMaximum(int arr[], int n)
    {
        long[][] dp = new long[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
        return solve(0, n-1, arr, n, dp);
    }
    
    static long solve(int i, int j, int[] a, int n, long[][] dp)
    {
        if(i > j)
            return 0L;
        if(dp[i][j] != -1)
            return dp[i][j];
        long first =  a[i] + Math.min(solve(i+2, j, a, n, dp), solve(i+1, j-1, a, n, dp));
        long last = a[j] + Math.min(solve(i, j-2, a, n, dp), solve(i+1, j-1, a, n, dp));
        return dp[i][j] = Math.max(first, last);
    }
}
