// { Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}
// } Driver Code Ends


class Solution
{
    public static String[] winner(String arr[], int n)
    {
        Map<String, Integer> hp = new HashMap<>();
        for(String s: arr)
            hp.put(s, hp.getOrDefault(s, 0) + 1);
        int max = 0;
        String winner = "";
        for(String s: hp.keySet())
        {
            if(hp.get(s) > max)
            {
                max = hp.get(s);
                winner = s;
            }
            else if(hp.get(s) == max && s.compareTo(winner) < 0)
                winner = s;
        }
        return new String[]{winner, max + ""};
    }
}