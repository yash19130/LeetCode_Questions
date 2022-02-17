class Solution 
{
    public String findLongestWord(String s, List<String> dictionary) 
    {
        Collections.sort(dictionary, new Comparator<String>()
        {
            @Override
            public int compare(String s1, String s2)
            {
                if(s1.length() == s2.length())
                    return s1.compareTo(s2);
                return s2.length() - s1.length();
            }
        });
        for(String d: dictionary)
        {
            int n = s.length(), m = d.length();
            int i = 0, j = 0;
            while(i < n && j < m)
            {
                if(s.charAt(i) == d.charAt(j))
                    j++;
                i++;
            }
            if(j == m)
                return d;
        }
        return "";
    }
}