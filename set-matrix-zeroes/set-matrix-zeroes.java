class Solution 
{
    static class point
    {
        int x, y;
        point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    public void setZeroes(int[][] matrix) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        ArrayList<point> a = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(matrix[i][j]==0)
                    a.add(new point(i, j));
            }
        }
        for(point p: a)
        {
            int i = p.x, j = p.y;
            while(i>=0)
                matrix[i--][j] = 0;
            i = p.x;
            while(i<n)
                matrix[i++][j] = 0;
            i = p.x;
            while(j>=0)
                matrix[i][j--] = 0;
            j = p.y;
            while(j<m)
                matrix[i][j++] = 0;
        }
    }
}