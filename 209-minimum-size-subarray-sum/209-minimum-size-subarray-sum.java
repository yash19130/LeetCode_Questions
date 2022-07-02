class Solution 
{
    public int minSubArrayLen(int target, int[] a) 
    {
        int n = a.length;
        int i = 0, j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(j < n)
        {
            sum += a[j];
            while(sum >= target)
            {
                min = Math.min(min, j - i + 1);
                sum -= a[i++];
            }
            j++;
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}