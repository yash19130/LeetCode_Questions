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

            Solution ob = new Solution();
            int[] ans = ob.changeBits(N);
            System.out.println(ans[0]+ " "+ ans[1]);
        }
    }
}// } Driver Code Ends



class Solution 
{
    public int[] changeBits(int N) 
    {
        int num = N;
        int b = 0;
        if(num == 0)
            b = 1;
        int two = 1;
        while(num != 0)
        {
            b += two;
            two *= 2;
            num /= 2;
        }
        return new int[]{b - N, b};
    }
}