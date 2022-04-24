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
            String a[] = in.readLine().trim().split("\\s+");
            long L = Long.parseLong(a[0]);
            long R = Long.parseLong(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.primeProduct(L, R));
        }
    }
}// } Driver Code Ends


class Solution
{
    static boolean isPrime(long n)
    {
        if(n == 1 || n == 2)
            return true;
        if(n % 2 == 0)
            return false;
        for(long i = 3; i * i <= n; i += 2)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    
    static long primeProduct(long L, long R)
    {
        long prod = 1;
        long mod = (long) (1e9 + 7);
        for(long i=L; i<=R; i++)
        {
            if(isPrime(i))
            {
                prod *= i;
                prod %= mod;
            }
        }
        return prod;
    }
}