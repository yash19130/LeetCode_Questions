// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transform (A, B));
                }
        }
}// } Driver Code Ends


class Solution
{
    public int transform(String a, String b)
    {
        if(a.length() != b.length())
            return -1;
        int sum = 0;
        int n = a.length();
        for(int i=0; i<n; i++)
        {
            sum += a.charAt(i);
            sum -= b.charAt(i);
        }
        if(sum != 0)
            return -1;
        int i = n-1, j = n-1;
        while(i >= 0 && j >= 0)
        {
            if(a.charAt(i) != b.charAt(j))
                sum++;
            else
                j--;
            i--;
        }
        return sum;
    }
}