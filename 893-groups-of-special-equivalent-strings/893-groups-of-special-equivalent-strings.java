class Solution 
{
    public int numSpecialEquivGroups(String[] words) 
    {
        Set<String> hs = new HashSet<>();
        for(String s: words)
        {
            int n = s.length();
            int[] odd = new int[26];
            int[] even = new int[26];
            for(int i=0; i<n; i++)
            {
                if((i & 1) == 0)
                    even[s.charAt(i) - 'a']++;
                else
                    odd[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++)
            {
                sb.append((char) ('a' + i));
                sb.append(even[i]);
            }
            for(int i=0; i<26; i++)
            {
                sb.append((char) ('a' + i));
                sb.append(odd[i]);
            }
            hs.add(sb.toString());
        }
        return hs.size();
    }
}