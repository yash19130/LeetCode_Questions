class Solution 
{
    public int[][] updateMatrix(int[][] mat) 
    {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        boolean[][] vis = new boolean[m][n];
        while(!q.isEmpty())
        {
            int i = q.peek()[0], j = q.peek()[1], d = q.peek()[2];
            q.poll();
            if(mat[i][j] == 1)
            {
                if(dist[i][j] == 0)
                    dist[i][j] = d;
                else
                    dist[i][j] = Math.min(dist[i][j], d);
            }
            int[] dx = {0, 0, -1, 1};
            int[] dy = {1, -1, 0, 0};
            for(int k=0; k<4; k++)
            {
                int x = i + dx[k];
                int y = j + dy[k];
                if(x >= 0 && x < m && y >= 0 && y < n)
                {
                    if(!vis[x][y] && mat[x][y] == 1)
                    {
                        vis[x][y] = true;
                        q.add(new int[]{x, y, d+1});
                    }
                }
            }
        }
        return dist;
    }
}