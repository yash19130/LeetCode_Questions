//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int maxSquare(int n, int m, int mat[][])
    {
        int ans = 0;
        for(int i=0; i<n; i++)
            ans = Math.max(ans, mat[i][0]);
        for(int j=0; j<m; j++)
            ans = Math.max(ans, mat[0][j]);
        for(int i=1; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                if(mat[i - 1][j - 1] > 0 && mat[i - 1][j] > 0 && mat[i][j - 1] > 0 && mat[i][j] == 1)
                    mat[i][j] = 1 + Math.min(mat[i - 1][j - 1], Math.min(mat[i - 1][j], mat[i][j - 1]));
                ans = Math.max(ans, mat[i][j]);
            }
        }
        return ans;
    }
}