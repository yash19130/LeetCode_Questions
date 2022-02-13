class Solution 
{
    public int splitArray(int[] a, int m) 
    {
        int beg = 0, end = 0;
        for(int i: a)
            end += i;
        int maxSum = 0;
        while(beg <= end)
        {
            int mid = beg + (end-beg)/2;
            if(possible(a, m, mid))
            {
                maxSum = mid;
                end = mid-1;
            }
            else
                beg = mid+1;
        }
        return maxSum;
    }
    
    public boolean possible(int[] a, int m, int maxSum)
    {
        int sum = 0, partitions = 1;
        for(int i: a)
        {
            if(i > maxSum)
                return false;
            sum += i;
            if(sum > maxSum)
            {
                partitions++;
                sum = i;
            }
        }
        return partitions <= m;
    }
}