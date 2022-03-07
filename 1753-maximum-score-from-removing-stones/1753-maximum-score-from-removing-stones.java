class Solution 
{
    public int maximumScore(int a, int b, int c) 
    {
        Queue<Integer> pq = new PriorityQueue<>((x,y)->(y-x));
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int score = 0;
        while(pq.size() > 1)
        {
            int x = pq.remove();
            int y = pq.remove();
            score++;
            if(x - 1 > 0)
                pq.add(x - 1);
            if(y - 1 > 0)
                pq.add(y - 1);
        }
        return score;
    }
}