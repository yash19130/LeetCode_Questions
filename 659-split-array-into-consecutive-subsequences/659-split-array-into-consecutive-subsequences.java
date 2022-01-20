class Solution 
{
    static class pair
    {
        int last, size;
        pair(int last, int size)
        {
            this.last = last;
            this.size = size;
        }
    }
    
    public boolean isPossible(int[] a) 
    {
        int n = a.length;
        List<pair> list = new ArrayList<>();
        list.add(new pair(a[0], 1));
        for(int i=1; i<n; i++)
        {
            boolean isAdded = false;
            int size = list.size();
            for(int j=size-1; j>=0; j--)
            {
                if(list.get(j).last + 1 == a[i])
                {
                    list.get(j).last++;
                    list.get(j).size++;
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded)
                list.add(new pair(a[i], 1));
        }
        for(pair p: list)
        {
            if(p.size < 3)
                return false;
        }
        return true;
    }
}