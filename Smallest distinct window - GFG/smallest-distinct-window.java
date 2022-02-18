// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str).length());
            
        }
	}
}

// } Driver Code Ends


class Solution 
{
    public String findSubString(String s)
    {
        Map<Character, Integer> hp = new HashMap<>();
        Set<Character> hs = new HashSet<>();
        for(char c: s.toCharArray())
            hs.add(c);
        int k = hs.size();
        int i = 0, j = 0, n = s.length();
        int min = n;
        while(j < n)
        {
            hp.put(s.charAt(j), hp.getOrDefault(s.charAt(j), 0) + 1);
            if(hp.size() == k)
            {
                min = Math.min(min, j-i+1);
                // System.out.println(min);
                while(i < j)
                {
                    char c = s.charAt(i++);
                    hp.put(c, hp.get(c) - 1);
                    if(hp.get(c) == 0)
                    {
                        hp.remove(c);
                        break;
                    }
                    // System.out.println(min + " " + hp.size());
                    min = Math.min(min, j-i+1);
                }
            }
            j++;
        }
        StringBuilder random = new StringBuilder();
        for(i=0; i<min; i++)
            random.append('a');
        return random.toString();
    }
}

