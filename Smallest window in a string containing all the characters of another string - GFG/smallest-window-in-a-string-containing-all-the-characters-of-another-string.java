// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends


class Solution
{
    public static String smallestWindow(String s, String p)
    {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int k = 0;
        for(char c: p.toCharArray())
        {
            if(cnt1[c - 'a'] == 0)
                k++;
            cnt1[c - 'a']++;
        }
        int i = 0, j = 0, n = s.length();
        int cur = 0;
        String ans = "-1";
        while(j < n)
        {
            cnt2[s.charAt(j) - 'a']++;
            if(cnt2[s.charAt(j) - 'a'] == cnt1[s.charAt(j) - 'a'])
                cur++;
            while(cur == k)
            {
                if(ans.equals("-1") || j - i + 1 < ans.length())
                    ans = s.substring(i, j + 1);
                char ch = s.charAt(i++);
                cnt2[ch - 'a']--;
                if(cnt2[ch - 'a'] < cnt1[ch - 'a'])
                {
                    cur--;
                    break;
                }
            }
            j++;
        }
        return ans;
    }
}