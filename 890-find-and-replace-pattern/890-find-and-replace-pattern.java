class Solution 
{
    public List<String> findAndReplacePattern(String[] words, String pat)
    {
        int n = pat.length();
        List<String> patterns = new ArrayList<>();
        for(String s: words)
        {
            if(s.length() != pat.length())
                continue;
            boolean samePattern = true;
            Map<Character, Character> hp1 = new HashMap<>();
            Map<Character, Character> hp2 = new HashMap<>();
            for(int i=0; i<n; i++)
            {
                char c1 = s.charAt(i), c2 = pat.charAt(i);
                if(hp1.get(c1) != null && hp1.get(c1) != c2)
                {
                    samePattern = false;
                    break;
                }
                if(hp2.get(c2) != null && hp2.get(c2) != c1)
                {
                    samePattern = false;
                    break;
                }
                hp1.put(c1, c2);
                hp2.put(c2, c1);
            }
            if(samePattern)
                patterns.add(s);
        }
        return patterns;
    }
}