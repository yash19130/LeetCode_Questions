class Solution
{
    public List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> anagrams = new ArrayList<>();
        if(p.length() > s.length())
            return anagrams;
        int n = s.length(), m = p.length();
        int[] cnt1 = new int[26];
        for(char c: p.toCharArray())
            cnt1[c - 'a']++;
        for(int i=0; i<=n-m; i++)
        {
            int[] cnt2 = new int[26];
            String cur = s.substring(i, i+m);
            for(char c: cur.toCharArray())
                cnt2[c - 'a']++;
            boolean isAnagram = true;
            for(int j=0; j<26; j++)
            {
                if(cnt1[j] != cnt2[j])
                {
                    isAnagram = false;
                    break;
                }
            }
            if(isAnagram)
                anagrams.add(i);
        }
        return anagrams;
    }
}