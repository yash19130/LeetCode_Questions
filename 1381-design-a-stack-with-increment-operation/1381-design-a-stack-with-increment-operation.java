class CustomStack 
{
    int[] stack;
    int top;
    
    public CustomStack(int maxSize) 
    {
        this.stack = new int[maxSize];
        this.top = -1;
    }
    
    public void push(int x) 
    {
        if(top == stack.length - 1)
            return;
        stack[++top] = x;    
    }
    
    public int pop() 
    {
        if(top == -1)
            return -1;
        return stack[top--];
    }
    
    public void increment(int k, int val) 
    {
        for(int i=0; i<k; i++)
        {
            if(i > top)
                return;
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */