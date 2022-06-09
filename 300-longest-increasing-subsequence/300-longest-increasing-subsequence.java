class Solution 
{
    public int lengthOfLIS(int[] a) 
    {        
        int n = a.length;
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for(int i=1; i<n; i++)
        {
            int end = list.size() - 1;
            if(a[i] > list.get(end))
            {
                list.add(a[i]);
                continue;
            }
            if(a[i] < list.get(0))
            {
                list.set(0, a[i]);
                continue;
            }
            int beg = 1, index = 1;
            while(beg <= end)
            {
                int mid = (beg + end)/2;
                if(a[i] < list.get(mid))
                {
                    index = mid;
                    end = mid - 1;
                }
                else
                    beg = mid + 1;
            }
            if(a[i] != list.get(index - 1))
                list.set(index, a[i]);
        }
        return list.size();
    }
}