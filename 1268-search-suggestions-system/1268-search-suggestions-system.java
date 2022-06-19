class Solution 
{
    public List<List<String>> suggestedProducts(String[] products, String searchWord) 
    {
        List<List<String>> ans = new ArrayList<>();
        int n = searchWord.length();
        Arrays.sort(products);
        for(int i=1; i<=n; i++)
        {
            String s = searchWord.substring(0, i);
            List<String> list = new ArrayList<>();
            for(String word: products)
            {
                if(word.indexOf(s) == 0)
                {
                    list.add(word);
                    if(list.size() == 3)
                        break;
                }
            }
            ans.add(list);
        }
        return ans;
    }
}