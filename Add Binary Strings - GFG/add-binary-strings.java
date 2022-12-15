//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


class Solution 
{
    public String addBinary(String a, String b) 
    {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0)
        {
            int sum = (a.charAt(i--) - '0') + (b.charAt(j--) - '0') + carry;
            if(sum > 1)
            {
                sum -= 2;
                carry = 1;
            }
            else
                carry = 0;
            sb.append(sum);
        }
        while(i >= 0)
        {
            int sum = (a.charAt(i--) - '0') + carry;
            if(sum > 1)
            {
                sum -= 2;
                carry = 1;
            }
            else
                carry = 0;
            sb.append(sum);
        }
        while(j >= 0)
        {
            int sum = (b.charAt(j--) - '0') + carry;
            if(sum > 1)
            {
                sum -= 2;
                carry = 1;
            }
            else
                carry = 0;
            sb.append(sum);
        }
        if(carry == 1)
            sb.append(1);
        String s = sb.reverse().toString();
        for(i=0; i<s.length(); i++)
            if(s.charAt(i) == '1')
                break;
        return s.substring(i);
    }
}