class TopVotedCandidate 
{
    public List<Integer> winners, times;
    
    public TopVotedCandidate(int[] persons, int[] times) 
    {
        this.winners = new ArrayList<>();
        this.times = new ArrayList<>();
        for(int t: times)
            this.times.add(t);
        Map<Integer, Integer> hp = new HashMap<>();
        int n = persons.length;
        int winner = 0, votes = 0;
        for(int p: persons)
        {
            hp.put(p, hp.getOrDefault(p, 0) + 1);
            if(hp.get(p) >= votes)
            {
                votes = hp.get(p);
                winner = p;
            }
            winners.add(winner);
        }
    }
    
    public int q(int t)
    {
        int beg = 0, end = times.size() - 1;
        int winner = 0;
        while(beg <= end)
        {
            int mid = beg + (end - beg) / 2;
            if(times.get(mid) <= t)
            {
                winner = winners.get(mid);
                beg = mid + 1;
            }
            else
                end = mid - 1;
        }
        return winner;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */