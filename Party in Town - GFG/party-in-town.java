// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    		for(int i = 0;i < N+1;i++){
    	        ArrayList<Integer> arr = new ArrayList<Integer>();
    	        adj.add(arr);
    		}
    		for(int i = 0;i < N-1;i++){
    		    String a[] = in.readLine().trim().split("\\s+");
    		    int x = Integer.parseInt(a[0]);
    		    int y = Integer.parseInt(a[1]);
    		    adj.get(x).add(y);
    		    adj.get(y).add(x);
    		}
    		
    		Solution ob = new Solution();
    		System.out.println(ob.partyHouse(N, adj));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int partyHouse(int N, ArrayList<ArrayList<Integer>> adj)
    {
        int minDist = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++)
            minDist = Math.min(minDist, bfs(i, N, adj));
        return minDist;
    }
    
    static int bfs(int s, int N, ArrayList<ArrayList<Integer>> adj)
    {
        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[N+1];
        q.add(new int[]{s, 0});
        vis[s] = true;
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            int u = q.peek()[0], dist = q.peek()[1];
            q.poll();
            for(int i: adj.get(u))
            {
                if(!vis[i])
                {
                    vis[i] = true;
                    min = dist+1;
                    q.add(new int[]{i, dist+1});
                }
            }
        }
        return min;
    }
}