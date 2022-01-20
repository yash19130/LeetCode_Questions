class Solution 
{
    public boolean isPossible(int[] a) 
    {
        int n = a.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(a[0]);
        list.add(temp);
        for(int i=1; i<n; i++)
        {
            boolean isAdded = false;
            int size = list.size();
            for(int j=size-1; j>=0; j--)
            {
                List<Integer> ls = list.get(j);
                int last = ls.get(ls.size()-1);
                if(last + 1 == a[i])
                {
                    ls.add(a[i]);
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded)
            {
                List<Integer> ls = new ArrayList<>();
                ls.add(a[i]);
                list.add(ls);
            }
        }
        for(List<Integer> ls: list)
        {
            if(ls.size() < 3)
                return false;
        }
        return true;
    }
}