// { Driver Code Starts
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
            String input_line[] = read.readLine().trim().split("\\s+");
            long N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            long ans = ob.killinSpree(N);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


class Solution
{
    long killinSpree(long n)
    {
        long killed = 0;
        long i = 1;
        while(i * i <= n)
        {
            killed++;
            n -= i * i;
            i++;
        }
        return killed;
    }
}