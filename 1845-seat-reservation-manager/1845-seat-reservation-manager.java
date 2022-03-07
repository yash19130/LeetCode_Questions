class SeatManager 
{
    public PriorityQueue<Integer> pq;
    
    public SeatManager(int n) 
    {
        this.pq = new PriorityQueue<>();
        for(int i=1; i<=n; i++)
            pq.add(i);
    }
    
    public int reserve() 
    {
        return pq.remove();
    }
    
    public void unreserve(int seatNumber) 
    {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */