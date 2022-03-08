class UndergroundSystem 
{   
    public Map<Integer, pair> customers;
    public Map<String, double[]> times;
        
    public UndergroundSystem() 
    {
        this.customers = new HashMap<>();
        this.times = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) 
    {
        customers.put(id, new pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) 
    {
        String stations = customers.get(id).s + " " + stationName;
        int t1 = customers.get(id).t;
        if(times.containsKey(stations))
        {
            double prevTime = times.get(stations)[0];
            double n = times.get(stations)[1];
            double newTime = ((prevTime * n) + (t - t1)) / (n + 1);
            times.put(stations, new double[]{newTime, n+1});
        }
        else
            times.put(stations, new double[]{t - t1, 1.0});
    }
    
    public double getAverageTime(String startStation, String endStation) 
    {
        return times.get(startStation + " " + endStation)[0];       
    }
}

class pair
{
    String s;
    int t;
    public pair(String s, int t)
    {
        this.s = s;
        this.t = t;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */