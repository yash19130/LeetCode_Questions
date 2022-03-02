// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            long ans = ob.countStrings(S); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


class Solution 
{
    long countStrings(String S) 
    {
        long[] cnt = new long[26];
        long n = S.length();
        for(char c: S.toCharArray())
            cnt[c - 'a']++;
        long ans = n * (n-1) / 2;
        for(int i=0; i<26; i++)
            ans -= (cnt[i] * (cnt[i] - 1)) / 2;
        if(ans == n * (n-1) / 2)
            return ans;
        return ans + 1;
    }
}