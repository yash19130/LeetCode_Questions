class Solution 
{
    public String minWindow(String s, String t) 
    {
        int n = s.length(), m = t.length();
        Map<Character, Integer> hp1 = new HashMap<>();
        Map<Character, Integer> hp2 = new HashMap<>();
        for(int i=0; i<m; i++)
            hp1.put(t.charAt(i), hp1.getOrDefault(t.charAt(i), 0) + 1);
        int k = hp1.size();
        int i = 0, j = 0;
        Set<Character> hs = new HashSet<>();
        String minWindow = "";
        while(j < n)
        {
            char c = s.charAt(j);
            hp2.put(c, hp2.getOrDefault(c, 0) + 1);
            if(hp1.containsKey(c) && hp1.get(c) <= hp2.get(c))
                hs.add(c);
            while(hs.size() == k)
            {
                if(minWindow.isEmpty() || j - i + 1 < minWindow.length())
                    minWindow = s.substring(i, j + 1);
                c = s.charAt(i++);
                hp2.put(c, hp2.get(c) - 1);
                if(hp1.containsKey(c) && hp2.get(c) < hp1.get(c))
                    hs.remove(c);
            }
            j++;
        }
        return minWindow;
    }
}