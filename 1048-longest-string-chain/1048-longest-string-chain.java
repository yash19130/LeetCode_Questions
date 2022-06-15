class Solution 
{
    public int longestStrChain(String[] words) 
    {
        Map<String, Integer> hp = new HashMap<>();
        Arrays.sort(words, (a, b) -> (b.length() - a.length()));
        for(String s: words)
            hp.put(s, 1);
        int longest = 1;
        for(String s: words)
        {
            for(int i=0; i<s.length(); i++)
            {
                String word = s.substring(0, i) + s.substring(i + 1);
                if(hp.containsKey(word))
                {
                    hp.put(word, Math.max(hp.get(word), hp.get(s) + 1));
                    longest = Math.max(longest, hp.get(word));
                }
            }
        }
        return longest;
    }
}