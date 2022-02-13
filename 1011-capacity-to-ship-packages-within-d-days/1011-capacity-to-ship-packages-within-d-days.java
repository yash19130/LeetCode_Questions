class Solution 
{
    public int shipWithinDays(int[] weights, int days) 
    {
        int beg = 0, end = 0;
        for(int w: weights)
            end += w;
        int maxLimit = 0;
        while(beg <= end)
        {
            int mid = beg + (end-beg)/2;
            if(possible(weights, days, mid))
            {
                maxLimit = mid;
                end = mid-1;
            }
            else
                beg = mid+1;
        }
        return maxLimit;
    }
    
    public boolean possible(int[] weights, int days, int limit)
    {
        int cur = 0, d = 1;
        for(int w: weights)
        {
            if(w > limit)
                return false;
            cur += w;
            if(cur > limit)
            {
                d++;
                cur = w;
            }
        }
        return d <= days;
    }
}