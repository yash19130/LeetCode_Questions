// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


class Solve 
{
    int[] findTwoElement(int arr[], int n) 
    {
        HashSet<Integer> hs = new HashSet<>();
		int[] ans = new int[2];
		for(int i=0; i<n; i++)
		{
			int x = arr[i];
			if(hs.contains(x))
				ans[0] = x;
			hs.add(x);
		}
		for(int i=1; i<=n; i++)
		{
			if(!hs.contains(i))
			{
				ans[1] = i;
				break;
			}
		}
		return ans;
    }
}
