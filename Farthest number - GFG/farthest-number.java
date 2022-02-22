// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
        	int N = Integer.parseInt(br.readLine()); 
        	int[] Arr = new int[N];
        	String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
        	for(int i=0; i<N; i++)
        	{
        		Arr[i] = Integer.parseInt(strs[i]); 
        	}
        	

            Solution ob = new Solution();
			int[] ans = ob.farNumber(N,Arr);
  
            for(int i=0; i<ans.length; i++)
                out.print(ans[i] + " ");
            out.println();

            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


class Solution 
{ 
    static int[] farNumber(int n, int a[])
	{
	    int[] ans = new int[n];
	    for(int i=0; i<n; i++)
	    {
	        int val = -1;
	        for(int j=n-1; j>i; j--)
	        {
	            if(a[j] < a[i])
	            {
	                val = j;
	                break;
	            }
	        }
	        ans[i] = val;
	    }
	    return ans;
	}
} 