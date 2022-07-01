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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.reverse(s));                        
        }
	}
}// } Driver Code Ends


class Solution
{
    public String reverse(String str)
    {
        Stack<Character> s = new Stack<>();
        int n = str.length();
        char[] ch = str.toCharArray();
        for(int i=0; i<n; i++)
        {
            if(Character.isAlphabetic(ch[i]))
                s.push(ch[i]);
        }
        for(int i=0; i<n; i++)
        {
            if(Character.isAlphabetic(ch[i]))
                ch[i] = s.pop();
        }
        return String.valueOf(ch);
    }
}