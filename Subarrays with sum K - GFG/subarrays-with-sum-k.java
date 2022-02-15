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
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}// } Driver Code Ends


class Solution
{
    static int findSubArraySum(int a[], int n, int k)
    {
        Map<Integer, Integer> hp = new HashMap<>();
        int count = 0, sum = 0;
        for(int i=0; i<n; i++)
        {
            sum += a[i];
            if(sum == k)
                count++;
            if(hp.containsKey(sum-k))
                count += hp.get(sum-k);
            hp.put(sum, hp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}