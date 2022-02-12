class Solution 
{
    public int search(List<Integer> list, int target)
    {
        int beg = 0, end = list.size()-1;
        int day = -1;
        while(beg <= end)
        {
            int mid = beg + (end-beg)/2;
            if(list.get(mid) >= target)
            {
                day = mid;
                end = mid-1;
            }
            else
                beg = mid+1;
        }
        return day;
    }
    
    public int maxEvents(int[][] events) 
    {
        Arrays.sort(events, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                if(a[1] == b[1])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=100000; i++)
            list.add(i);
        int ans = 0;
        for(int[] e: events)
        {
            int day = search(list, e[0]);
            if(day != -1 && list.get(day) <= e[1])
            {
                ans++;
                list.remove(day);
            }
        }
        return ans;
    }
}