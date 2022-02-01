// { Driver Code Starts
//Initial Template for Java

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
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		ArrayList <ArrayList <Integer>> res = new Solution().binTreeSortedLevels (arr, n);
    		
    		for (int i = 0; i < res.size(); i++)
    		{
    		    for (int j = 0; j < (res.get (i).size()); j++)
    		    {
    		        System.out.print (res.get(i).get(j) + " ");
    		    }
    		    System.out.println ();
    		}
        }
        
    }
}

// Contributed By: Pranay Bansal
// } Driver Code Ends


class Solution
{
    static ArrayList<ArrayList<Integer>> binTreeSortedLevels(int a[], int n)
    {
        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<>();
        int level = 1;
        int elements = 0;
        while(elements < n)
        {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=Math.min(level+elements-1, n-1); j>=elements; j--)
                list.add(a[j]);
            elements += list.size();
            Collections.sort(list);
            levelOrder.add(list);
            level *= 2;
        }
        return levelOrder;
    }
}