// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        int c = 0;
        String prefix = str.substring(0, k);
        for(String s: arr)
        {
            if(s.length() < k)
                continue;
            if(s.substring(0, k).equals(prefix))
                c++;
        }
        return c;
    }
}