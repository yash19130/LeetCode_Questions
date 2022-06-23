class Solution 
{
    public int minFallingPathSum(int[][] matrix) 
    {
        int n = matrix.length;
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                int cur = matrix[i - 1][j];
                if(j - 1 >= 0)
                    cur = Math.min(cur, matrix[i - 1][j - 1]);
                if(j + 1 < n)
                    cur = Math.min(cur, matrix[i - 1][j + 1]);
                matrix[i][j] += cur;
            }
        }
        int ans = matrix[n - 1][0];
        for(int j=1; j<n; j++)
            ans = Math.min(ans, matrix[n - 1][j]);
        return ans;
    }
}