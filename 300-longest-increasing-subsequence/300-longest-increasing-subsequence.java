class Solution 
{
    public int lengthOfLIS(int[] a) 
    {        
        int n = a.length;
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for(int i=1; i<n; i++)
        {
            int beg = 0, end = list.size() - 1;
            int index = 0;
            if(a[i] > list.get(end))
            {
                list.add(a[i]);
                continue;
            }
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
            if(index > 0 && a[i] == list.get(index - 1))
                continue;
            list.set(index, a[i]);
        }
        return list.size();
    }
}