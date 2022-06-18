class WordFilter 
{
    public String[] words;
    public Map<String, List<Integer>> hp;
    
    public WordFilter(String[] words) 
    {
        this.words = words;
        this.hp = new HashMap<>();
        int n = words.length;
        for(int i=0; i<n; i++)
        {
            int m = words[i].length();
            for(int j=0; j<m; j++)
            {
                add(words[i].substring(0, j + 1), i);
            }
        }
    }
    
    public void add(String s, int i)
    {
        if(hp.containsKey(s))
            hp.get(s).add(i);
        else
        {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            hp.put(s, list);
        }
    }
    
    public int f(String prefix, String suffix) 
    {
        if(!hp.containsKey(prefix))
            return -1;
        List<Integer> list = hp.get(prefix);
        int n = list.size();
        for(int i=n-1; i>=0; i--)
        {
            if(words[list.get(i)].endsWith(suffix))
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