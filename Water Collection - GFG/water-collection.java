// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().maxWater(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution 
{
    int maxWater(int a[], int n) 
    {
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = a[0];
        for(int i=1; i<n; i++)
            left[i] = Math.max(left[i-1], a[i]);
        right[n-1] = a[n-1];
        for(int i=n-2; i>=0; i--)
            right[i] = Math.max(right[i+1], a[i]);
        int water = 0;
        for(int i=1; i<n-1; i++)
            water += Math.min(left[i], right[i]) - a[i];
        return water;
    }
}