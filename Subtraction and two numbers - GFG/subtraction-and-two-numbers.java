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
            String S[]=read.readLine().split(" ");
            int A=Integer.parseInt(S[0]);
            int B=Integer.parseInt(S[1]);
            Solution ob = new Solution();
            System.out.println(ob.repeatedSubtraction(A,B));
        }
    }
}// } Driver Code Ends


class Solution
{
    int repeatedSubtraction(int A, int B)
    {
        int steps = 0;
        while(A > 0 && B > 0)
        {
            steps++;
            if(A > B)
                A -= B;
            else
                B -= A;
        }
        return steps;
    }
}