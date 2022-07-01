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
    public String reverse(String s)
    {
        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();
        while(i < j)
        {
            if(Character.isAlphabetic(ch[i]) && Character.isAlphabetic(ch[j]))
            {
                char c = ch[i];
                ch[i] = ch[j];
                ch[j] = c;
                i++;
                j--;
            }
            else if(!Character.isAlphabetic(ch[i]))
                i++;
            else if(!Character.isAlphabetic(ch[j]))
                j--;
            else
            {
                i++;
                j--;
            }
        }
        return String.valueOf(ch);
    }
}