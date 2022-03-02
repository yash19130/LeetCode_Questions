// { Driver Code Starts
//Initial Template for Java

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
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            System.out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
    }
}

// } Driver Code Ends


class Solution
{
    static int[] endPoints(int[][] arr, int n, int m)
    {
        int i = 0, j = 0;
        char dir = 'R';
        int[] lastPoint = new int[2];
        while(i >= 0 && i < n && j >= 0 && j < m)
        {
            lastPoint[0] = i;
            lastPoint[1] = j;
            if(arr[i][j] == 1)
            {
                arr[i][j] = 0;
                if(dir == 'U')
                    dir = 'R';
                else if(dir == 'R')
                    dir = 'D';
                else if(dir == 'D')
                    dir = 'L';
                else
                    dir = 'U';
            }
            if(dir == 'U')
                i--;
            else if(dir == 'R')
                j++;
            else if(dir == 'D')
                i++;
            else
                j--;
        }
        return lastPoint;
    }
}