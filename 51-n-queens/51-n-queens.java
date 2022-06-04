class Solution 
{
    public List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) 
    {
        List<String> emptyBoard = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++)
                sb.append('.');
            emptyBoard.add(sb.toString());
        }
        for(int j=0; j<n; j++)
            NQueens(0, j, n, new ArrayList<>(emptyBoard));
        return ans;
    }
    
    public void NQueens(int i, int j, int n, List<String> board)
    {
        if(i >= n)
            return;
        for(int row=0; row<n; row++)
            if(board.get(row).charAt(j) == 'Q')
                return;
        for(int col=0; col<n; col++)
            if(board.get(i).charAt(col) == 'Q')
                return;
        for(int row = i, col = j; row >= 0 && col >= 0; row--, col--)
            if(board.get(row).charAt(col) == 'Q')
                return;
        for(int row = i, col = j; row >= 0 && col < n; row--, col++)
            if(board.get(row).charAt(col) == 'Q')
                return;
        for(int row = i, col = j; row < n && col >= 0; row++, col--)
            if(board.get(row).charAt(col) == 'Q')
                return;
        for(int row = i, col = j; row < n && col < n; row++, col++)
            if(board.get(row).charAt(col) == 'Q')
                return;
        StringBuilder sb = new StringBuilder();
        StringBuilder empty = new StringBuilder();
        for(int col=0; col<n; col++)
        {
            if(col == j)
                sb.append('Q');
            else
                sb.append('.');
            empty.append('.');
        }
        board.set(i, sb.toString());
        for(int col=0; col<n; col++)
            NQueens(i+1, col, n, new ArrayList<>(board));
        if(i == n-1)
            ans.add(new ArrayList<>(board));
        board.set(i, empty.toString());
    }
}