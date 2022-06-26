class Solution 
{
    public int maxScore(int[] a, int k) 
    {
        int n = a.length;
        int sum = 0;
        for(int i=0; i<k; i++)
            sum += a[i];
        int max = sum;
        int j = k - 1;
        for(int i=n-1; i>=n-k; i--)
        {
            sum += a[i];
            sum -= a[j--];
            max = Math.max(max, sum);
        }
        return max;
    }
}