class MyHashSet 
{
    static class Node
    {
        Node next;
        int data;
        Node(int data)
        {
            this.data = data;
        }
    }
    
    public Node[] hp;
    
    public MyHashSet() 
    {
        this.hp = new Node[10000];    
    }
    
    public void add(int key) 
    {
        if(contains(key))
            return;
        int pos = key % 10000;
        if(hp[pos] == null)
            hp[pos] = new Node(key);
        else
        {
            Node node = new Node(key);
            node.next = hp[pos];
            hp[pos] = node;
        }
    }
    
    public void remove(int key) 
    {
        int pos = key % 10000;
        Node temp = hp[pos], prev = null;
        while(temp != null)
        {
            if(temp.data == key)
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
                    temp.data = temp.next.data;
                    temp.next = temp.next.next;
                }
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }
    
    public boolean contains(int key) 
    {
        int pos = key % 10000;
        Node temp = hp[pos];
        while(temp != null)
        {
            if(temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */