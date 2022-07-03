public class Solution 
{
    public int wiggleMaxLength(int[] a) 
    {
        int n = a.length;
        if (n < 2)
            return n;
        int down = 1, up = 1;
        for(int i=1; i<n; i++) 
        {
            if(a[i] > a[i - 1])
                up = down + 1;
            else if (a[i] < a[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }
}