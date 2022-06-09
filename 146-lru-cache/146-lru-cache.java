class LRUCache 
{
    public LinkedHashMap<Integer, Integer> hp;
    public int capacity;

    public LRUCache(int capacity) 
    {
        this.hp = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) 
    {
        if(!hp.containsKey(key))
            return -1;
        int value = hp.get(key);
        hp.remove(key);
        hp.put(key, value);
        return value;
    }
    
    public void put(int key, int value) 
    {
        if(hp.containsKey(key))
            hp.remove(key);
        hp.put(key, value);
        if(hp.size() > capacity)
        {
            for(int k: hp.keySet())
            {
                hp.remove(k);
                return;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */