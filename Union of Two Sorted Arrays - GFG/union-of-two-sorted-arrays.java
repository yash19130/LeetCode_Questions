// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}


// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    public static ArrayList<Integer> findUnion(int a[], int b[], int n, int m)
    {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n && j < m)
        {
            if(i > 0 && i < n && a[i] == a[i-1])
            {
                i++;
                continue;
            }
            if(j > 0 && j < m && b[j] == b[j-1])
            {
                j++;
                continue;
            }
            if(a[i] == b[j])
            {
                union.add(a[i]);
                i++;
                j++;
            }
            else if(a[i] < b[j])
                union.add(a[i++]);
            else
                union.add(b[j++]);
        }
        while(i < n)
        {
            if(i > 0 && i < n && a[i] == a[i-1])
            {
                i++;
                continue;
            }
            union.add(a[i++]);
        }
        while(j < m)
        {
            if(j > 0 && j < m && b[j] == b[j-1])
            {
                j++;
                continue;
            }
            union.add(b[j++]);
        }
        return union;
    }
}