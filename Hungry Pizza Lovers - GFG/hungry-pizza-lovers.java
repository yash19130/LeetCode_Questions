// { Driver Code Starts
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
		    
		    int arr [][] = new int[sizeOfArray][2];
		    
		    for(int i = 0;i<sizeOfArray;i++){
    		    line = br.readLine();
    		    String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);
		    }
		    
		    Complete obj = new Complete();
		    ArrayList<Integer> ans;
		    ans = obj.permute(arr, sizeOfArray);
		    for(int i: ans)
		        System.out.println(i);
		}
	}
}


// } Driver Code Ends


class Complete
{
    public static ArrayList<Integer> permute(int arr[][], int n)
    {
        int[][] orders = new int[n][3];
        for(int i=0; i<n; i++)
            orders[i] = new int[]{arr[i][0], arr[i][1], i + 1};
        Arrays.sort(orders, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                int t1 = a[0] + a[1];
                int t2 = b[0] + b[1];
                if(t1 == t2)
                    return a[2] - b[2];
                return t1 - t2;
            }
        });
        ArrayList<Integer> pizzaOrder = new ArrayList<>();
        for(int i=0; i<n; i++)
            pizzaOrder.add(orders[i][2]);
        return pizzaOrder;
    }
}