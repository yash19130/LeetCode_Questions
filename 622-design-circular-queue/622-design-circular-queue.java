class MyCircularQueue 
{
    public Node head, tail;
    int size, limit;
    
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    }
    
    public MyCircularQueue(int k)
    {
        this.size = 0;
        this.limit = k;
    }
    
    public boolean enQueue(int data)
    {
        if(size == limit)
            return false;
        Node node = new Node(data);
        size++;
        if(head == null)
            head = node;
        else
            tail.next = node;
        tail = node;
        tail.next = head;
        return true;
    }
    
    public boolean deQueue()
    {
        if(size == 0)
            return false;
        if(size == 1)
        {
            head = tail = null;
            size--;
            return true;
        }
        head = head.next;
        tail.next = head;
        size--;
        return true;
    }
    
    public int Front()
    {
        if(size == 0)
            return -1;
        return head.data;
    }
    
    public int Rear()
    {
        if(size == 0)
            return -1;
        return tail.data;
    }
    
    public boolean isEmpty()
    {
        return size == 0;    
    }
    
    public boolean isFull()
    {
        return size == limit;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */