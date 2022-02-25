class BrowserHistory 
{
    List<String> list;
    int pos;
    
    public BrowserHistory(String homepage) 
    {
        this.list = new ArrayList<>();
        this.pos = 0;
        list.add(homepage);
    }
    
    public void visit(String url) 
    {
        while(pos + 1 < list.size())
            list.remove(pos+1);
        list.add(url);
        pos = list.size()-1;
    }
    
    public String back(int steps) 
    {
        pos -= steps;
        if(pos < 0)
            pos = 0;
        return list.get(pos);
    }
    
    public String forward(int steps) 
    {
        pos += steps;
        if(pos >= list.size())
            pos = list.size()-1;
        return list.get(pos);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */