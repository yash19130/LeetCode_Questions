class Solution 
{
    public int maximumUniqueSubarray(int[] a) 
    {
        Set<Integer> vis = new HashSet<>();
        int n = a.length;
        int i = 0, j = 0;
        int sum = 0, max = 0;
        while(j < n)
        {
            if(vis.contains(a[j]))
            {
                vis.remove(a[i]);
                sum -= a[i++];
            }
            else
            {
                vis.add(a[j]);
                sum += a[j++];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}