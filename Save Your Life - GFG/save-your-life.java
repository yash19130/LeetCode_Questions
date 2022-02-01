// { Driver Code Starts
import java.io.*;
import java.util.*;

 // } Driver Code Ends
class Solution
{
    static String maxSum(String w, char x[], int b[], int n)
    {
        int ascii[] = new int[256];
        for(int i=0; i<256; i++)
            ascii[i] = i;
        for(int i=0; i<n; i++)
            ascii[x[i]] = b[i]; 
        int max = ascii[w.charAt(0)];
        String curString = w.charAt(0) + "", maxString = w.charAt(0) + "";
        int sum = ascii[w.charAt(0)];
        for(int i=1; i<w.length(); i++)
        {
            char c = w.charAt(i);
            if(ascii[c] > sum + ascii[c])
            {
                curString = c + "";
                sum = ascii[c];
            }
            else
            {
                curString += c;
                sum += ascii[c];
            }
            if(sum > max)
            {
                max = sum;
                maxString = curString;
            }
        }
        return maxString;
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
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}  // } Driver Code Ends