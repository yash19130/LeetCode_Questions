class Solution 
{
    public int minDeletions(String s) 
    {
        int[] cnt = new int[26];
        for(char c: s.toCharArray())
            cnt[c - 'a']++;
        TreeMap<Integer, Integer> hp = new TreeMap<>();
        Set<Integer> hs = new HashSet<>();
        for(int i=0; i<26; i++)
            hp.put(cnt[i], hp.getOrDefault(cnt[i], 0) + 1);
        if(hp.containsKey(0))
            hp.remove(0);
        int ans = 0;
        for(int k: hp.keySet())
        {
            int c = hp.get(k);
            hs.add(k);
            while(c-->1)
            {
                int cur = k;
                while(hs.contains(cur) && cur != 0)
                {
                    ans++;
                    cur--;
                }
                hs.add(cur);
            }
        }
        return ans;
    }
}