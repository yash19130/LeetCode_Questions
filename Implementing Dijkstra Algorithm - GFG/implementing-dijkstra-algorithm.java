// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    static class node implements Comparable<node>
    {
        int v, d;
        node(int v, int d)
        {
            this.v = v;
            this.d = d;
        }
    
        @Override
        public int compareTo(node n)
        {
            return this.d - n.d;
        }
    }
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int dist[] = new int[V];
        for(int i=0; i<V; i++)
            dist[i] = Integer.MAX_VALUE;
        boolean vis[] = new boolean[V];
        dist[S] = 0;
        node cur = new node(S, 0);
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(cur);
        while(!pq.isEmpty())
        {
            cur = pq.remove();
            vis[cur.v] = true;
            for(ArrayList<Integer> a: adj.get(cur.v))
            {
                int v = a.get(0), d = a.get(1);
                if(!vis[v] && dist[cur.v] != Integer.MAX_VALUE && dist[cur.v] + d < dist[v])
                {
                    dist[v] = dist[cur.v] + d;
                    pq.add(new node(v, dist[v]));    
                }
            }
        }
        return dist;
    }
}

