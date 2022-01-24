// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


class Solution
{
    static List<Integer> nextPermutation(int n, int a[])
    {
        List<Integer> perm = new ArrayList<>();
        int i = n-2;
        while(i >= 0)
        {
            if(a[i] < a[i+1])
                break;
            i--;
        }
        if(i == -1)
        {
            for(i=n-1; i>=0; i--)
                perm.add(a[i]);
            return perm;
        }
        int j = n-1;
        while(j >= i+1)
        {
            if(a[j] > a[i])
            {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                break;
            }
            j--;
        }
        for(int k=0; k<=i; k++)
            perm.add(a[k]);
        for(int k=n-1; k>i; k--)
            perm.add(a[k]);
        return perm;
    }
}