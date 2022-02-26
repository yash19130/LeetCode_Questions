class Solution 
{
    public int shortestPathLength(int[][] graph) 
    {
        int n = graph.length;
        if(n == 1)
            return 0;
        int endMask = (1 << n) - 1;
        boolean[][] vis = new boolean[n][endMask];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            q.add(new int[]{i, 1 << i});
            vis[i][1 << i] = true;
        }
        int minPath = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-->0)
            {
                int node = q.peek()[0], mask = q.peek()[1];
                q.poll();
                for(int i: graph[node])
                {
                    int nextMask = mask | (1 << i);
                    if(nextMask == endMask)
                        return minPath + 1;
                    if(!vis[i][nextMask])
                    {
                        vis[i][nextMask] = true;
                        q.add(new int[]{i, nextMask});
                    }
                }
            }
            minPath++;
        }
        return -1;
    }
}