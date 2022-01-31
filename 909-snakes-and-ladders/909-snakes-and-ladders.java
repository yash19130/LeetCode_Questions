class Solution 
{
    public int snakesAndLadders(int[][] board) 
    {
        int n = board.length;
        boolean order = true;
        int cur = 0;
        Map<Integer, Integer> hp = new HashMap<>();
        for(int i=n-1; i>=0; i--)
        {
            if(order)
            {
                for(int j=0; j<n; j++)
                {
                    cur++;
                    if(board[i][j] != -1)
                        hp.put(cur, board[i][j]);                
                }
            }
            else
            {
                for(int j=n-1; j>=0; j--)
                {
                    cur++;
                    if(board[i][j] != -1)
                        hp.put(cur, board[i][j]);                
                }
            }
            order = !order;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[(n*n)+1];
        q.add(new int[]{1, 0});
        vis[1] = true;
        while(!q.isEmpty())
        {
            int pos = q.peek()[0];
            int moves = q.peek()[1];
            q.poll();
            if(pos == n*n)
                return moves;
            for(int i=pos+1; i<=Math.min(pos+6, n*n); i++)
            {
                if(vis[i])
                    continue;
                vis[i] = true;
                int j = i;
                if(hp.containsKey(j))
                    j = hp.get(j);
                q.add(new int[]{j, moves+1});
            }
        }
        return -1;
    }
}