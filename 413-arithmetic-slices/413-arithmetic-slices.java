class Solution 
{
    public int numberOfArithmeticSlices(int[] a) 
    {
        int n = a.length;
        if(n < 3)
            return 0;
        int prev = 0;
        int ans = 0;
        for(int i=1; i<n-1; i++)
        {
            if(a[i] - a[i-1] == a[i+1] - a[i])
                ans += ++prev;
            else
                prev = 0;
        }
        return ans;
    }
}