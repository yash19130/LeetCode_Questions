class Solution 
{
    public int[][] generateMatrix(int n) 
    {
        int[][] mat = new int[n][n];
        int i = 0, j = 0;
        char dir = 'R';
        int val = 1;
        while(val <= n * n)
        {
            switch(dir)
            {
                case 'R':
                    while(j < n && mat[i][j] == 0)
                        mat[i][j++] = val++;
                    j--;
                    i++;
                    dir = 'D';
                    break;
                case 'L':
                    while(j >= 0 && mat[i][j] == 0)
                        mat[i][j--] = val++;
                    j++;
                    i--;
                    dir = 'U';
                    break;
                case 'U':
                    while(i >= 0 && mat[i][j] == 0)
                        mat[i--][j] = val++;
                    i++;
                    j++;
                    dir = 'R';
                    break;
                case 'D':
                    while(i < n && mat[i][j] == 0)
                        mat[i++][j] = val++;
                    i--;
                    j--;
                    dir = 'L';
                    break;
            }
        }
        return mat;
    }
}