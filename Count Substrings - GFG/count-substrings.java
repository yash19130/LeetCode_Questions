// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next();

    		System.out.println (new Solution().countSubstr (s));
        }
        
    }
}

// Contributed By: Pranay Bansal
// } Driver Code Ends


class Solution
{
    int countSubstr(String S)
    {
        int n = 0;
        for(char c: S.toCharArray())
            if(c == '1')
                n++;
        return n * (n-1) / 2;
    }
}