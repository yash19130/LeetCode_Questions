// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution 
{
    static String[] findPrefixes(String[] arr, int N) 
    {
        String ans[] = new String[arr.length];
        int j = 0;
        for(String s: arr)
        {
            int n = s.length();
            for(int i=1; i<=n; i++)
            {
                String cur = s.substring(0, i);
                if(check(arr, cur))
                {
                    ans[j++] = cur;
                    break;
                }
            }
        }
        return ans;
    }
    
    static boolean check(String[] arr, String cur)
    {
        int count = 0;
        for(String s: arr)
        {
            if(s.indexOf(cur) == 0)
                count++;
            if(count == 2)
                return false;
        }
        return true;
    }
}