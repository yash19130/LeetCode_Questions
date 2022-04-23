// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}// } Driver Code Ends


class Solution
{
    static int searchInsertK(int a[], int n, int k)
    {
        if(a[n-1] < k)
            return n;
        int beg = 0, end = n-1;
        int pos = 0;
        while(beg <= end)
        {
            int mid = beg + (end - beg) / 2;
            if(a[mid] >= k)
            {
                pos = mid;
                end = mid - 1;
            }
            else
                beg = mid + 1;
        }
        return pos;
    }
}