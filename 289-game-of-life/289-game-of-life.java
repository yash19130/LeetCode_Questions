class Solution 
{
    public void gameOfLife(int[][] board) 
    {
        int m = board.length, n = board[0].length;
        int[][] temp = new int[m][n];
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
                        temp[i][j] = 1;
                }
                else if(liveNeighbors == 3)
                    temp[i][j] = 1;
            }
        }
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                board[i][j] = temp[i][j];                
    }
    
    public boolean isLiveNeighbor(int i, int j, int[][] board)
    {
        int m = board.length, n = board[0].length;
        return i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 1;
    }
}