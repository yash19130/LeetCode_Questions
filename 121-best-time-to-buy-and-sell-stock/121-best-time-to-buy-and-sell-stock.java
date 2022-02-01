class Solution 
{
    public int maxProfit(int[] a) 
    {
        int n = a.length;
        int min = a[0];
        int maxProfit = 0;
        for(int i=0; i<n; i++)
        {
            min = Math.min(min, a[i]);
            maxProfit = Math.max(maxProfit, a[i]-min);
        }
        return maxProfit;
    }
}