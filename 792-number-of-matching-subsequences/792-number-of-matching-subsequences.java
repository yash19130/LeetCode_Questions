class Solution 
{
    public boolean isSubsequence(Map<Character, List<Integer>> hp, String s)
    {
        int n = s.length();
        int index = -1;
        for(int i=0; i<n; i++)
        {
            if(!hp.containsKey(s.charAt(i)))
                return false;
            List<Integer> list = hp.get(s.charAt(i));
            int beg = 0, end = list.size() - 1;
            int curIndex = -1;
            while(beg <= end)
            {
                int mid = beg + (end - beg) / 2;
                if(list.get(mid) > index)
                {
                    curIndex = list.get(mid);
                    end = mid - 1;
                }
                else
                    beg = mid + 1;
            }
            if(curIndex == -1)
                return false;
            index = curIndex;
        }
        return true;
    }
    
    public int numMatchingSubseq(String s, String[] words) 
    {
        int ans = 0;
        Map<Character, List<Integer>> hp = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++)
            hp.put(s.charAt(i), new ArrayList<>());
        for(int i=0; i<n; i++)
            hp.get(s.charAt(i)).add(i);
        for(String w: words)
            if(isSubsequence(hp, w))
                ans++;
        return ans;
    }
}