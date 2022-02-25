// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countOfSubstrings(S,K));
        }
    }
}// } Driver Code Ends


class Solution 
{
    static int countOfSubstrings(String s, int k) 
    {
        int n = s.length();
        int count = 0;
        Map<Character, Integer> hp = new HashMap<>();
        for(int i=0; i<k; i++)
            hp.put(s.charAt(i), hp.getOrDefault(s.charAt(i), 0) + 1);
        if(hp.size() == k-1)
            count++;
        for(int i=k; i<n; i++)
        {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i-k);
            hp.put(c1, hp.getOrDefault(c1, 0) + 1);
            hp.put(c2, hp.get(c2) - 1);
            if(hp.get(c2) == 0)
                hp.remove(c2);
            if(hp.size() == k-1)
                count++;
        }
        return count;
    }
}