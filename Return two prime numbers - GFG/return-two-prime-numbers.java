// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.primeDivision(N);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}// } Driver Code Ends


class Solution
{
    static boolean isPrime(int n)
    {
        if(n<=1)
            return false;
        if(n==2)
            return true;
        if(n%2==0)
            return false;
        for(int i=3; i<= Math.sqrt(n)+1; i=i+2)
            if(n%i==0)
                return false;
        return true;
    }
    
    static List<Integer> primeDivision(int n)
    {
        List<Integer> a = new ArrayList<>();
        for(int i=2; i<=n; i++)
        {
            if(isPrime(i) && isPrime(n-i))
            {
                a.add(i);
                a.add(n-i);
                return a;
            }
        }
        return a;
    }
}