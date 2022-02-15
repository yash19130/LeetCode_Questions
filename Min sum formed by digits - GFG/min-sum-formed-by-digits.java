// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.minSum(a, n));
            
        }
	}
}

// } Driver Code Ends


class Solution 
{
    public static long minSum(int a[], int n)
    {
        if(n == 1)
            return (long) a[0];
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++)
            pq.add(a[i]);
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();
        while(pq.size() > 1)
        {
            n1.append(pq.poll());
            n2.append(pq.poll());
        }
        if(!pq.isEmpty())
            n1.append(pq.poll());
        return Long.parseLong(n1.toString()) + Long.parseLong(n2.toString());
    }
}