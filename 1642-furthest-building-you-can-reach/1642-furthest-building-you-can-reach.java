class Solution 
{
    public int furthestBuilding(int[] h, int bricks, int ladders) 
    {
        int n = h.length;
        Queue<int[]> bricksNeeded = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for(int i=1; i<n; i++)
        {
            if(h[i] > h[i - 1])
            {
                if(bricksNeeded.size() < ladders)
                {
                    bricksNeeded.add(new int[]{h[i] - h[i - 1], i});
                }
                else if(!bricksNeeded.isEmpty() && bricksNeeded.peek()[0] < h[i] - h[i - 1])
                {
                    bricksNeeded.poll();
                    bricksNeeded.add(new int[]{h[i] - h[i - 1], i});
                }
            }
        }
        TreeSet<Integer> hs = new TreeSet<>();
        while(ladders > 0 && bricksNeeded.size() > 0)
        {
            hs.add(bricksNeeded.poll()[1]);
            ladders--;
        }
        int i = 1;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        while(i < n)
        {
            if(h[i] <= h[i - 1] || hs.contains(i))
            {
                i++;
                continue;
            }
            if(bricks >= h[i] - h[i - 1])
            {
                bricks -= (h[i] - h[i - 1]);
                pq.add(h[i] - h[i - 1]);
            }
            else
            {
                if(hs.isEmpty() || hs.last() < i)
                    break;
                hs.remove(hs.last());
                if(!pq.isEmpty() && pq.peek() > h[i] - h[i - 1])
                {
                    bricks += pq.peek();
                    pq.poll();
                    bricks -= h[i] - h[i - 1];
                    pq.add(h[i] - h[i - 1]);
                }
            }
            i++;
        }
        return i - 1;
    }
}