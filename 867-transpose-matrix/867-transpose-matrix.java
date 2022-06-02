class Solution 
{
    public int[][] transpose(int[][] mat) 
    {
        int m = mat.length, n = mat[0].length;
        int[][] t = new int[n][m];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                t[j][i] = mat[i][j];
        return t;
    }
}