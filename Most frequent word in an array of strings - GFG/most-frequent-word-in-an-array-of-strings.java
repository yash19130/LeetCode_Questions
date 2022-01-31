// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

 // } Driver Code Ends


class Solution
{
    public String mostFrequentWord(String arr[], int n)
    {
        Map<String, Integer> hp = new LinkedHashMap<>();
        for(String s: arr)
            hp.put(s, hp.getOrDefault(s, 0) + 1);
        int freq = 0;
        for(String s: hp.keySet())
            freq = Math.max(freq, hp.get(s));
        String ans = "";
        for(String s: hp.keySet())
            if(hp.get(s) == freq)
                ans = s;
        return ans;
    }
}


// { Driver Code Starts.  // } Driver Code Ends