class WordFilter 
{
    public String[] words;
    public Map<String, List<Integer>> prefix;
    
    public WordFilter(String[] words) 
    {
        this.words = words;
        this.prefix = new HashMap<>();
        int n = words.length;
        for(int i=0; i<n; i++)
        {
            int m = words[i].length();
            for(int j=0; j<m; j++)
                addPrefix(words[i].substring(0, j + 1), i);
        }
    }
    
    public void addPrefix(String s, int i)
    {
        if(prefix.containsKey(s))
            prefix.get(s).add(i);
        else
        {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            prefix.put(s, list);
        }
    }
    
    public int f(String p, String s) 
    {
        if(!prefix.containsKey(p))
            return -1;
        List<Integer> list = prefix.get(p);
        int n = list.size();
        for(int i=n-1; i>=0; i--)
        {
            if(words[list.get(i)].endsWith(s))
                return list.get(i);
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */