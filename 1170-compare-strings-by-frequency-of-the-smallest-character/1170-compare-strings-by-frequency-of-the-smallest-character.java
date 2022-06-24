class Solution 
{
    public int search(List<Integer> list, int k)
    {
        int beg = 0, end = list.size() - 1;
        int ans = 0;
        while(beg <= end)
        {
            int mid = beg + (end - beg) / 2;
            if(list.get(mid) > k)
            {
                ans = list.size() - mid;
                end = mid - 1;
            }
            else
                beg = mid + 1;
        }
        return ans;
    }
    
    public int[] numSmallerByFrequency(String[] q, String[] words) 
    {
        int n = q.length;
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();
        for(String w: words)
        {
            char smallest = 'z';
            for(char c: w.toCharArray())
            {
                if(c < smallest)
                    smallest = c;
            }
            int f = 0;
            for(char c: w.toCharArray())
            {
                if(c == smallest)
                    f++;
            }
            list.add(f);
        }
        Collections.sort(list);
        int i = 0;
        for(String s: q)
        {
            char smallest = 'z';
            for(char c: s.toCharArray())
            {
                if(c < smallest)
                    smallest = c;
            }
            int f = 0;
            for(char c: s.toCharArray())
            {
                if(c == smallest)
                    f++;
            }
            ans[i++] = search(list, f);
        }
        return ans;
    }
}