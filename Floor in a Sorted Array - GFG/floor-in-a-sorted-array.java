// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           System.out.println(new Solution().findFloor(arr, n, x));
          
        }
    }
    
}// } Driver Code Ends


class Solution
{
    static int findFloor(long arr[], int n, long x)
    {
        int beg = 0, end = n-1;
        int index = -1;
        while(beg <= end)
        {
            int mid = beg + (end - beg)/2;
            if(arr[mid] <= x)
            {
                index = mid;
                beg = mid+1;
            }
            else
                end = mid-1;
        }
        return index;
    }
}
