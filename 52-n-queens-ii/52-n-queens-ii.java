class Solution 
{
    public int totalNQueens(int n) 
    {
        int ans = 0;
        for(int j=0; j<n; j++)
            ans += NQueens(0, j, n, new boolean[n][n]);
        return ans;
    }
    
    public int NQueens(int i, int j, int n, boolean[][] isQueen)
    {
        if(i >= n)
            return 0;
        for(int row = 0; row < i; row++)
            if(isQueen[row][j])
                return 0;
        for(int row = i, col = j; row >= 0 && col >= 0; row--, col--)
            if(isQueen[row][col])
                return 0;
        for(int row = i, col = j; row >= 0 && col < n; row--, col++)
            if(isQueen[row][col])
                return 0;
        isQueen[i][j] = true;
        int ways = 0;
        if(i == n - 1)
            ways = 1;
        for(int col = 0; col < n; col++)
            ways += NQueens(i + 1, col, n, isQueen);
        isQueen[i][j] = false;
        return ways;
    }
}