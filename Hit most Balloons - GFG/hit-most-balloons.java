// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            int arr[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (int i = 0; i < N; i++) {
                    arr[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBalloons(N, arr));
        }
    }
}
// } Driver Code Ends


class Solution 
{
    public int mostBalloons(int n, int a[][]) 
    {
        if(n <= 2)
            return n;
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            int cnt = 0;
            Map<Double, Integer> hp = new HashMap<>();
            for(int j=0; j<n; j++)
            {
                if(a[i][0] == a[j][0] && a[i][1] == a[j][1])
                {
                    cnt++;
                    continue;
                }
                double y = (double) (a[j][1]-a[i][1]);
                double x = (double) (a[j][0]-a[i][0]);
                double slope = (double) (y / x);
                hp.put(slope, hp.getOrDefault(slope, 0) + 1);
            }
            for(int v: hp.values())
                ans = Math.max(ans, v + cnt);
        }
        return ans;
    }
}