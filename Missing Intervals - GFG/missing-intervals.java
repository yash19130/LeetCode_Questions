// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String input_line[] = read.readLine().trim().split("\\s+");
            int a[]= new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            int vec[] = ob.printMissingIntervals(a, n);
            
            for(int i=0 ; i<vec.length ; i+=2)
            {
                if (vec[i]==vec[i+1])
                    System.out.print(vec[i]);
                else
                {
                    System.out.print(vec[i]);
                    System.out.print("-");
                    System.out.print(vec[i+1]);
                }
                if(i!=vec.length-2)
                    System.out.print(",");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int[] printMissingIntervals(int[] a, int n)
    {
        List<Integer> missing = new ArrayList<>();
        if(a[0] - 0 > 0)
        {
            missing.add(0);
            missing.add(a[0]-1);
        }
        for(int i=1; i<n; i++)
        {
            if(a[i] - a[i-1] > 1)
            {
                missing.add(a[i-1] + 1);
                missing.add(a[i] - 1);
            }
        }
        if(99999 - a[n-1] > 0)
        {
            missing.add(a[n-1] + 1);
            missing.add(99999);
        }
        int x = missing.size();
        int[] missingIntervals = new int[x];
        for(int i=0; i<x; i++)
            missingIntervals[i] = missing.get(i);
        return missingIntervals;
    }
};