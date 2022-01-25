// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}// } Driver Code Ends


class Solution 
{
    static int leastWeightCapacity(int[] arr, int N, int D) 
    {
        int beg = 0, end = 0;
        for(int i: arr)
        {
            beg = Math.max(beg, i);
            end += i;
        }
        int limit = 0;
        while(beg <= end)
        {
            int mid = beg+(end-beg)/2;
            if(possible(arr, N, D, mid))
            {
                limit = mid;
                end = mid-1;
            }
            else
                beg = mid+1;
        }
        return limit;
    }
    
    static boolean possible(int[] a, int n, int d, int limit)
    {
        int curDays = 1;
        int load = 0;
        for(int i=0; i<n; i++)
        {
            load += a[i];
            if(load > limit)
            {
                curDays++;
                load = a[i];
            }
        }
        return curDays <= d;
    }
}