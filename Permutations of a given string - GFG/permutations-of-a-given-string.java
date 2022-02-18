// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution 
{
    List<String> ans = new ArrayList<>();
    
    public List<String> find_permutation(String s)
    {
        char chars[] = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);
        backtrack(0, s, "");
        return ans;
    }
    
    public void backtrack(int i, String s, String cur)
    {
        if(cur.length() == s.length())
            ans.add(cur);
        for(int j=0; j<s.length(); j++)
        {
            boolean isChar = false;
            for(char c: cur.toCharArray())
                if(c == s.charAt(j))
                    isChar = true;
            if(isChar)
                continue;
            backtrack(j+1, s, cur + s.charAt(j));
        }
    }
}