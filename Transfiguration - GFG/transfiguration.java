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
                    System.out.println(obj.transfigure (A, B));
                }
        }
}// } Driver Code Ends


class Solution
{
    int transfigure(String A, String B)
    {
        if(A.length() != B.length())
            return -1;
        int n = A.length();
        int cnt1[] = new int[256];
        int cnt2[] = new int[256];
        for(int i=0; i<n; i++)
        {
            cnt1[A.charAt(i)]++;
            cnt2[B.charAt(i)]++;
        }
        for(int i=0; i<256; i++)
        {
            if(cnt1[i] != cnt2[i])
                return -1;
        }
        int i = n-1, j = n-1;
        int transfigurations = 0;
        while(i >= 0 && j >= 0)
        {
            if(A.charAt(i) == B.charAt(j))
            {
                i--;
                j--;
            }
            else
            {
                i--;
                transfigurations++;
            }
        }
        return transfigurations;
    }
}