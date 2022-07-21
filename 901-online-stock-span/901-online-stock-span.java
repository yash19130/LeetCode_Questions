class StockSpanner 
{
    public Stack<int[]> s;
    public int index;
    
    public StockSpanner() 
    {
        this.s = new Stack<>();
        this.index = 1;
    }
    
    public int next(int price) 
    {
        while(!s.isEmpty() && s.peek()[0] <= price)
            s.pop();
        int cur = s.isEmpty() ? 0 : s.peek()[1];
        s.push(new int[]{price, index});
        return index++ - cur;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */