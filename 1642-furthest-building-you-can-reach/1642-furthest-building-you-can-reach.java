class Solution 
{
    public int furthestBuilding(int[] h, int bricks, int ladders) 
    {
        int n = h.length;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<n; i++)
        {
            if(h[i] <= h[i - 1])
                continue;
            pq.add(h[i] - h[i - 1]);
            if(pq.size() > ladders)
            {
                if(bricks >= pq.peek())
                    bricks -= pq.poll();
                else
                    return i - 1;
            }
        }
        return n - 1;
    }
}