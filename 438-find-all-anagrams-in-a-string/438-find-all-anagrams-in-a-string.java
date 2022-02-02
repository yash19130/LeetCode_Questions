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
        int[] cnt2 = new int[26];
        for(int i=0; i<m; i++)
            cnt2[s.charAt(i) - 'a']++;
        if(isAnagram(cnt1, cnt2))
            anagrams.add(0);
        for(int i=m; i<n; i++)
        {
            cnt2[s.charAt(i) - 'a']++;
            cnt2[s.charAt(i-m) - 'a']--;
            if(isAnagram(cnt1, cnt2))
                anagrams.add(i-m+1);
        }
        return anagrams;
    }
    
    public boolean isAnagram(int[] cnt1, int[] cnt2)
    {
        for(int i=0; i<26; i++)
            if(cnt1[i] != cnt2[i])
                return false;
        return true;
    }
}