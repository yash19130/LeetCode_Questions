class Solution 
{
    public int maxDistToClosest(int[] a) 
    {
        int n = a.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<n; i++)
            if(a[i] == 1)
                set.add(i);
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            if(a[i] == 1)
                continue;
            Integer lo = set.lower(i);
            Integer hi = set.higher(i);
            if(lo == null)
                ans = Math.max(ans, hi - i);
            else if(hi == null)
                ans = Math.max(ans, i - lo);
            else
                ans = Math.max(ans, Math.min(hi - i, i - lo));
        }
        return ans;
    }
}