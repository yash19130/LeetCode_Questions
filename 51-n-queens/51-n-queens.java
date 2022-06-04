class Solution 
{
    public List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) 
    {
        for(int j=0; j<n; j++)
            NQueens(0, j, n, new boolean[n][n]);
        return ans;
    }
    
    public void NQueens(int i, int j, int n, boolean[][] isQueen)
    {
        if(i >= n)
            return;
        for(int row = 0; row < i; row++)
            if(isQueen[row][j])
                return;
        for(int row = i, col = j; row >= 0 && col >= 0; row--, col--)
            if(isQueen[row][col])
                return;
        for(int row = i, col = j; row >= 0 && col < n; row--, col++)
            if(isQueen[row][col])
                return;
        isQueen[i][j] = true;
        if(i == n - 1)
        {
            List<String> arrangement = new ArrayList<>();
            for(int row = 0; row < n; row++)
            {
                StringBuilder sb = new StringBuilder();
                for(int col = 0; col < n; col++)
                {
                    if(isQueen[row][col])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                arrangement.add(sb.toString());
            }
            ans.add(arrangement);
        }
        for(int col = 0; col < n; col++)
            NQueens(i + 1, col, n, isQueen);
        isQueen[i][j] = false;
    }
}