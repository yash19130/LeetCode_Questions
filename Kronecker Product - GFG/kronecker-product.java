// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int p = Integer.parseInt(arr[2]);
            int q = Integer.parseInt(arr[3]);
            int A[][] = new int[n][m];
            int B[][] = new int[p][q];
            for(int i = 0;i < n;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    A[i][j] = Integer.parseInt(a1[j]);
            }
            for(int i = 0;i < p;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < q;j++)
                    B[i][j] = Integer.parseInt(a1[j]);
            }
            
            Solution ob = new Solution();
            int ans[][] = ob.kroneckerProduct(n, m, p, q, A, B);
            for(int i = 0;i < n*p;i++){
                for(int j = 0;j < m*q;j++)
                    out.print(ans[i][j] + " ");
                out.println();
            }
        }
        out.flush();
    }
}// } Driver Code Ends


class Solution
{
    int[][] kroneckerProduct(int n, int m, int p, 
                                         int q, int A[][], int B[][])
    {
        int ans[][] = new int[n * p][m * q];
        for(int i=0; i<n; i++)
	        for(int j=0; j<m; j++)
	            for(int k=0; k<p; k++)
	                for(int l=0; l<q; l++)
	                    ans[i*p+k][j*q+l] = A[i][j] * B[k][l];
	   return ans;
    }
}