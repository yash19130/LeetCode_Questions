// { Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S1 = read.readLine();
            String S2 = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.findTime(S1,S2));
        }
    }
}// } Driver Code Ends


class Solution 
{
    public int findTime(String S1 , String S2) 
    {
        int n = S1.length();
        int[] pos = new int[26];
        for(int i=0; i<n; i++)
            pos[S1.charAt(i) - 'a'] = i;
        int time = 0;
        int i = 0;
        for(char c: S2.toCharArray())
        {
            time += Math.abs(pos[c - 'a'] - i);
            i = pos[c - 'a'];
        }
        return time;
    }
}