class Solution 
{
    public long minimumRemoval(int[] beans) 
    {
        Arrays.sort(beans);
        int n = beans.length;
        long sum = 0;
        for(int i=0; i<n; i++)
            sum += beans[i];
        long ans = sum;
        for(int i=0; i<n; i++)
            ans = Math.min(ans, sum - ((n - i) * (long) beans[i]));
        return ans;
    }
}