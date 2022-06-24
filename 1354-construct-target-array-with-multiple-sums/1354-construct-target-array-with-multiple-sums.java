class Solution 
{
    public boolean isPossible(int[] target) 
    {
        Queue<Long> pq = new PriorityQueue<>((a, b) -> (int) (b - a));
        long sum = 0;
        for(int i: target)
        {
            sum += i;
            pq.add((long) i);
        }
        while(pq.peek() != 1)
        {
            long cur = pq.poll();
            sum -= cur;
            if(sum == 1)
                return true;
            if (cur < sum || sum == 0 || cur % sum == 0)
                return false;
            cur %= sum;
            sum += cur;
            pq.add(cur);
        }
        return true;
    }
}