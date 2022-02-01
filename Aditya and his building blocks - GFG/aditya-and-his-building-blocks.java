// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Complete obj = new Complete();
		    int ans = obj.maximised_height(arr, sizeOfArray, M);
		    System.out.println(ans);
		}
	}
}

// } Driver Code Ends


class Complete
{
    public static int maximised_height(int a[], int n, int m) 
    {
        Arrays.sort(a);
        long beg = 0, end = m;
        for(int i: a)
            end += i;
        long minHeight = 0;
        while(beg <= end)
        {
            long mid = beg + (end-beg)/2;
            if(possible(a, n, m, mid))
            {
                minHeight = mid;
                beg = mid+1;
            }
            else
                end = mid-1;
        }
        return (int) minHeight;
    }
    
    public static boolean possible(int[] a, int n, int m, long height)
    {
        for(int i=0; i<n; i++)
        {
            if(a[i] < height)
                m -= (height-a[i]);
            if(m < 0)
                return false;
        }
        return true;
    }
}