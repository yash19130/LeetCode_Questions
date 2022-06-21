class Solution 
{
    public int furthestBuilding(int[] h, int bricks, int ladders) 
    {
        int n = h.length;
        List<int[]> bricksNeeded = new ArrayList<>();
        for(int i=1; i<n; i++)
        {
            if(h[i] > h[i - 1])
                bricksNeeded.add(new int[]{h[i] - h[i - 1], i});
        }
        Collections.sort(bricksNeeded, (a, b) -> (b[0] - a[0]));
        TreeSet<Integer> hs = new TreeSet<>();
        for(int i = 0; i < Math.min(bricksNeeded.size(), ladders); i++)
            hs.add(bricksNeeded.get(i)[1]);
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