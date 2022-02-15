// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            String s = input[0];
            int k = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.countOfSubstringWithKOnes(s, k));
        }
    }
}// } Driver Code Ends


class Solution
{
    long countOfSubstringWithKOnes(String s, int k)
    {
        int n = s.length();
        long ones = 0, count = 0;
        Map<Long, Long> hp = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == '1')
                ones++;
            if(ones == k)
                count++;
            if(hp.containsKey(ones-k))
                count += hp.get(ones-k);
            hp.put(ones, hp.getOrDefault(ones, 0L) + 1);
        }
        return count;
    }
}