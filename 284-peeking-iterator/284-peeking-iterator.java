// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> 
{
    public Deque<Integer> dq;
    
	public PeekingIterator(Iterator<Integer> iterator) 
    {
	    // initialize any member here.
        this.dq = new ArrayDeque<>();
        while(iterator.hasNext())
            dq.addLast(iterator.next());
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() 
    {
        return dq.peekFirst();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() 
    {
	    return dq.removeFirst();
	}
	
	@Override
	public boolean hasNext() 
    {
	    return dq.size() > 0;    
	}
}