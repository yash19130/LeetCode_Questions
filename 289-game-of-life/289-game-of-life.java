class Solution 
{
    public void gameOfLife(int[][] board) 
    {
        int m = board.length, n = board[0].length;
        int[] dx = {0, 1, -1, 0, -1, -1, 1, 1};
        int[] dy = {1, 0, 0, -1, -1, 1, -1, 1};
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int liveNeighbors = 0;
                for(int k=0; k<8; k++)
                {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(isLiveNeighbor(x, y, board))
                        liveNeighbors++;
                }
                if(board[i][j] == 1)
                {
                    if(liveNeighbors == 2 || liveNeighbors == 3)
                        board[i][j] = 1;
                    else
                        board[i][j] = -1;
                }
                else if(liveNeighbors == 3)
                    board[i][j] = 2;
            }
        }
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == -1)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
    
    public boolean isLiveNeighbor(int i, int j, int[][] board)
    {
        int m = board.length, n = board[0].length;
        return i >= 0 && i < m && j >= 0 && j < n && Math.abs(board[i][j]) == 1;
    }
}