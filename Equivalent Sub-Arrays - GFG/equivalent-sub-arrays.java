// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


 // } Driver Code Ends

 
class Solution
{
    public int countDistinctSubarray(int a[], int n) 
    {
        Set<Integer> hs = new HashSet<>();
        for(int i=0; i<n; i++)
            hs.add(a[i]);
        return atMostK(a, n, hs.size()) - atMostK(a, n, hs.size() - 1);
    }
    
    public int atMostK(int[] a, int n, int k)
    {
        Map<Integer, Integer> hp = new HashMap<>();
        int i = 0, j = 0;
        int ans = 0;
        while(j < n)
        {
            hp.put(a[j], hp.getOrDefault(a[j], 0) + 1);
            while(hp.size() > k)
            {
                int x = a[i++];
                hp.put(x, hp.get(x) - 1);
                if(hp.get(x) == 0)
                    hp.remove(x);
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}

// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}
  // } Driver Code Ends