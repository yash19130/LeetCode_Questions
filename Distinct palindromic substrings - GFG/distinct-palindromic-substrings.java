// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim(); 
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    int palindromeSubStrs(String s) 
    { 
        int n = s.length();
        HashSet<String> hs = new HashSet<>();
        hs.add(s.charAt(0) + "");
        hs.add(s.charAt(n-1) + "");
        for(int k=1; k<n-1; k++)
        {
            int i = k-1, j = k+1;
            while(i >= 0 && j < n && s.charAt(i) == s.charAt(j))
            {
                hs.add(s.substring(i, j+1));
                i--;
                j++;
            }
            hs.add(s.charAt(k) + "");
        }
        for(int k=0; k<n-1; k++)
        {
            int i = k, j = k+1;
            while(i >= 0 && j < n && s.charAt(i) == s.charAt(j))
            {
                hs.add(s.substring(i, j+1));
                i--;
                j++;
            }
        }
        return hs.size();
    }
} 