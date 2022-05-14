class Solution 
{
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        Graph g = new Graph(n);
        for(int[] e: times)
            g.add(e[0] - 1, e[1] - 1, e[2]);
        return g.dijkstra(k - 1);
    }
}

class Graph
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
    
    List<List<int[]>> adj;
    int V;
    Graph(int V)
    {
        this.V = V;
        this.adj = new ArrayList<>();
        for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());
    }
    
    public void add(int u, int v, int w)
    {
        adj.get(u).add(new int[]{v, w});
    }
    
    public int dijkstra(int S)
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
            for(int[] a: adj.get(cur.v))
            {
                int v = a[0], d = a[1];
                if(!vis[v] && dist[cur.v] != Integer.MAX_VALUE && dist[cur.v] + d < dist[v])
                {
                    dist[v] = dist[cur.v] + d;
                    pq.add(new node(v, dist[v]));    
                }
            }
        }
        int time = 0;
        for(int d: dist)
            time = Math.max(time, d);
        if(time == Integer.MAX_VALUE)
            return -1;
        return time;
    }
}