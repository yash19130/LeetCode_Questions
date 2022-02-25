// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends


class Solution
{
    public static String moveRobots(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        int i = 0, j = 0;
        while(i < n && j < m)
        {
            if(s1.charAt(i) == '#' && s2.charAt(j) == '#')
            {
                i++;
                j++;
                continue;
            }
            if(s1.charAt(i) == '#')
            {
                i++;
                continue;
            }
            if(s2.charAt(j) == '#')
            {
                j++;
                continue;
            }
            if(s1.charAt(i) != s2.charAt(j))
                return "No";
            if((s1.charAt(i) == 'A' && j > i) || (s2.charAt(j) == 'B' && j < i))
                return "No";
            i++;
            j++;
        }
        return "Yes";
    }
}


// { Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s1=read.readLine();
            String s2=read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.moveRobots(s1, s2));
        }
    }
}  // } Driver Code Ends