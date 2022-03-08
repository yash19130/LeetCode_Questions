// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends


class Solution
{
    public static ArrayList<Integer> RopeCutting(int arr[], int n) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> hp = new TreeMap<>();
        for(int i: arr)
            hp.put(i, hp.getOrDefault(i, 0) + 1);
        int size = n;
        for(int i: hp.keySet())
        {
            size -= hp.get(i);
            if(size > 0)
                ans.add(size);
        }
        return ans;
    }
}



// { Driver Code Starts.
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] =  Integer.parseInt(elements[i]);
		    }
		    
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res;
		    res = obj.RopeCutting(arr, sizeOfArray);
		    for(int i: res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            

  // } Driver Code Ends