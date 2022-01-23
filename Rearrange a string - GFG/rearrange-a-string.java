// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.arrangeString(s));
                }
                
        }
}
// } Driver Code Ends


class Solution
{
    public String arrangeString(String s)
    {
        int alph[] = new int[26];
        int sum = -1;
        for(char c: s.toCharArray())
        {
            if(c >= 48 && c <= 57)
                sum += c - 48;
            else
                alph[c - 'A']++;
        }
        StringBuilder str = new StringBuilder();
        for(int i=0; i<26; i++)
        {
            int count = alph[i];
            char c = (char) (i + 'A');
            while(count-->0)
                str.append(c);
        }
        if(sum == -1)
            return str.toString();
        str.append(++sum);
        return str.toString();
    }
}