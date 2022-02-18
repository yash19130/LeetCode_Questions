// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}
// } Driver Code Ends


class Solution 
{
    public String removeKdigits(String num, int k) 
    {
        Stack<Character> s = new Stack<>();
        for(char c: num.toCharArray())
        {
            while(!s.isEmpty() && k > 0 && s.peek() > c)
            {
                k--;
                s.pop();
            }
            s.push(c);
        }
        while(k > 0)
        {
            if(!s.isEmpty())
                s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty())
            sb.append(s.pop());
        sb.reverse();
        int i = 0, n = sb.length();
        while(i < n && sb.charAt(i) == '0')
            i++;
        String ans = sb.toString().substring(i);
        if(ans.isEmpty())
            return "0";
        return ans;
    }
}