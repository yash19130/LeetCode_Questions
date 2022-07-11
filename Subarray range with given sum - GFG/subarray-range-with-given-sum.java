// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
	public static void main (String[] args)
	 {
    	 Scanner sc=new Scanner(System.in);
    	 int t=sc.nextInt();
    	 while(t-->0)
    	 {
    	        int n = sc.nextInt();
    		    int arr[] = new int[n];
    		    for(int i=0;i<n;i++)
    		    {
    		        arr[i] = sc.nextInt();
    		    }
    		    int sum = sc.nextInt();
    		    System.out.println(new Solution().subArraySum(arr, n, sum));
    		    
    		}
	}
}// } Driver Code Ends


class Solution
{
    static int subArraySum(int arr[], int n, int target)
    {
        Map<Integer, Integer> hp = new HashMap<>();
        int sum = 0, ans = 0;
        hp.put(0, 1);
        for(int i=0; i<n; i++)
        {
            sum += arr[i];
            if(hp.containsKey(sum - target))
                ans += hp.get(sum - target);
            hp.put(sum, hp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}