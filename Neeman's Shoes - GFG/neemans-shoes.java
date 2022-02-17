// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int src = Integer.parseInt(s[2]);
            int dest = Integer.parseInt(s[3]);
            int X = Integer.parseInt(s[4]);
            ArrayList<ArrayList<Integer>> A = new ArrayList<>();
            for(int i = 0; i < M; i++)
                A.add(i, new ArrayList<Integer>());
            for(int i = 0; i < M; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                A.get(i).add(u);
                A.get(i).add(v);
                A.get(i).add(w);
            }
            Solution obj = new Solution();
            System.out.println(obj.exercise(N, M, A, src, dest, X));
        }
    }
}// } Driver Code Ends


class Solution
{
    public String exercise(int N, int M, ArrayList<ArrayList<Integer>> A, int src, int dest, int X)
    {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<N; i++)
            adj.add(new ArrayList<>());
        for(ArrayList<Integer> a: A)
        {
            int u = a.get(0), v = a.get(1), d = a.get(2);
            adj.get(u).add(new int[]{v, d});
            adj.get(v).add(new int[]{u, d});
        }
        if(dijkstra(N, adj, src, dest) <= X)
            return "Neeman's Cotton Classics";
        return "Neeman's Wool Joggers";
    }
    
    public int dijkstra(int N, ArrayList<ArrayList<int[]>> adj, int s, int dest)
    {
        int dist[] = new int[N];
        for(int i=0; i<N; i++)
            dist[i] = Integer.MAX_VALUE;
        boolean vis[] = new boolean[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)->(x[1]-y[1]));
        pq.add(new int[]{s, 0});
        dist[s] = 0;
        while(!pq.isEmpty())
        {
            int[] cur = pq.remove();
            vis[cur[0]] = true;
            for(int[] a: adj.get(cur[0]))
            {
                int v = a[0], d = a[1];
                if(!vis[v] && dist[cur[0]] != Integer.MAX_VALUE && dist[cur[0]] + d < dist[v])
                {
                    dist[v] = dist[cur[0]] + d;
                    pq.add(new int[]{v, dist[v]});    
                }
            }
        }
        return dist[dest];
    }
}