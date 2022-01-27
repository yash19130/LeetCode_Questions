// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    String list[] = new String[n];
                    for(int i = 0;i<n;i++)
                        list[i] = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.countWords(list, n));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countWords(String list[], int n)
    {
        Map<String, Integer> hp = new HashMap<>();
        for(String s: list)
        {
            if(hp.containsKey(s))
                hp.put(s, hp.get(s)+1);
            else
                hp.put(s, 1);
        }
        int pairs = 0;
        for(String s: hp.keySet())
            if(hp.get(s) == 2)
                pairs++;
        return pairs;
    }
}