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
            System.out.println(ob.findPosition(N));
        }
    }
}// } Driver Code Ends


class Solution
{
    static int findPosition(int N)
    {
        int pos = -1;
        int i = 1;
        while(N != 0)
        {
            int bit = N % 2;
            if(bit == 1 && pos != -1)
                return -1;
            if(bit == 1)
                pos = i;
            i++;
            N /= 2;
        }
        return pos;
    }
}