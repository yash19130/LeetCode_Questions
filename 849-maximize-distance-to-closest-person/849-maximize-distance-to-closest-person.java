class Solution 
{
    public int maxDistToClosest(int[] a) 
    {
        int n = a.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++)
            if(a[i] == 1)
                q.add(i);
        Integer ans = 0, lo = null;
        for(int i=0; i<n; i++)
        {
            if(a[i] == 1)
            {
                lo = q.poll();
                continue;
            }
            Integer hi = q.isEmpty() ? null : q.peek();
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