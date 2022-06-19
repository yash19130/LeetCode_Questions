class Solution 
{
    public List<List<String>> suggestedProducts(String[] products, String s) 
    {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        Map<String, List<String>> hp = new HashMap<>();
        Arrays.sort(products);
        for(String word: products)
        {
            int m = word.length();
            for(int i=1; i<=m; i++)
            {
                String cur = word.substring(0, i);
                if(hp.containsKey(cur))
                {
                    if(hp.get(cur).size() < 3)
                        hp.get(cur).add(word);
                }
                else
                {
                    List<String> list = new ArrayList<>();
                    list.add(word);
                    hp.put(cur, list);
                }
            }
        }
        for(int i=1; i<=n; i++)
        {
            String cur = s.substring(0, i);
            if(!hp.containsKey(cur))
                ans.add(new ArrayList<>());
            else
                ans.add(hp.get(cur));
        }
        return ans;
    }
}