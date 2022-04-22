class MyHashMap 
{
    static class Node
    {
        Node next;
        int key, value;
        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    public Node[] hp;
    
    public MyHashMap() 
    {
        this.hp = new Node[10000];
    }
    
    public void put(int key, int value) 
    {
        int pos = key % 10000;
        if(hp[pos] == null)
        {
            hp[pos] = new Node(key, value);
            return;
        }
        Node temp = hp[pos], prev = null;
        while(temp != null)
        {
            if(temp.key == key)
            {
                temp.value = value;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        prev.next = new Node(key, value);
    }
    
    public int get(int key) 
    {
        int pos = key % 10000;
        Node temp = hp[pos];
        while(temp != null)
        {
            if(temp.key == key)
                return temp.value;
            temp = temp.next;
        }
        return -1;
    }
    
    public void remove(int key) 
    {
        int pos = key % 10000;
        Node temp = hp[pos], prev = null;
        while(temp != null)
        {
            if(temp.key == key)
            {
                if(temp.next == null)
                {
                    if(prev == null)
                        hp[pos] = null;
                    else
                        prev.next = null;
                }
                else
                {
                    temp.key = temp.next.key;
                    temp.value = temp.next.value;
                    temp.next = temp.next.next;
                }
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */