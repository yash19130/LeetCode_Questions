class Solution 
{
    public int minimumDeviation(int[] a) 
    {
        int n = a.length;
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->(y-x));
        for(int i=0; i<n; i++)
        {
            if(a[i] % 2 != 0)
                a[i] *= 2;
            min = Math.min(min, a[i]);
            pq.add(a[i]);
        }
        int ans = Integer.MAX_VALUE;
        while(true)
        {
            int max = pq.peek();
            if(max % 2 != 0)
                break;
            pq.remove();
            ans = Math.min(ans, max-min);
            min = Math.min(min, max/2);
            pq.add(max/2);
        }
        return Math.min(ans, pq.peek()-min);
    }
}