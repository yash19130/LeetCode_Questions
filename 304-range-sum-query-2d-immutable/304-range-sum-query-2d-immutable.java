class NumMatrix 
{
    public List<List<Integer>> prefixRows;
    
    public NumMatrix(int[][] matrix) 
    {
        this.prefixRows = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++)
        {
            List<Integer> row = new ArrayList<>();
            row.add(matrix[i][0]);
            for(int j=1; j<n; j++)
                row.add(matrix[i][j] + row.get(j-1));
            prefixRows.add(row);
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) 
    {
        int sum = 0;
        for(int i=row1; i<=row2; i++)
        {
            sum += prefixRows.get(i).get(col2);
            if(col1 >= 1)
                sum -= prefixRows.get(i).get(col1 - 1);
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */