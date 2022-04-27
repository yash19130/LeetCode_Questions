// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[]= new int[N];
            for(int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> cost = ob.candyStore(candies,N,K);
            System.out.println(cost.get(0)+" "+cost.get(1));
        }
    }
}
// } Driver Code Ends


class Solution
{
    static ArrayList<Integer> candyStore(int candies[], int N, int K)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        Arrays.sort(candies);
        ans.add(solve(candies, N, K));
        int rev[] = new int[N];
        for(int i=0; i<N; i++)
            rev[i] = candies[N - i - 1];
        ans.add(solve(rev, N, K));
        return ans;
    }
    
    static int solve(int[] candies, int N, int K)
    {
        int i = 0, j = N-1;
        int money = 0;
        while(i <= j)
        {
            money += candies[i++];
            j -= K;
        }
        return money;
    }
}

