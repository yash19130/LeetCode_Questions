class Solution 
{
    public boolean closeStrings(String word1, String word2) 
    {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(char c: word1.toCharArray())
            cnt1[c - 'a']++;
        for(char c: word2.toCharArray())
            cnt2[c - 'a']++;
        Map<Integer, Integer> hp1 = new HashMap<>();
        Map<Integer, Integer> hp2 = new HashMap<>();
        for(int i=0; i<26; i++)
        {
            int c1 = cnt1[i], c2 = cnt2[i];
            if((c1 == 0 && c2 > 0) || (c1 > 0 && c2 == 0))
                return false;
            hp1.put(c1, hp1.getOrDefault(c1, 0) + 1);
            hp2.put(c2, hp2.getOrDefault(c2, 0) + 1);
        }
        for(int k: hp1.keySet())
        {
            if(!hp2.containsKey(k) || hp1.get(k) != hp2.get(k))
                return false;
        }
        return true;
    }
}