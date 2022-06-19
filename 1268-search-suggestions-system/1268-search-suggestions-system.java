class Solution 
{
    public int search(String[] products, String s)
    {
        int beg = 0, end = products.length - 1;
        int pos = -1;
        while(beg <= end)
        {
            int mid = beg + (end - beg) / 2;
            if(s.compareTo(products[mid]) <= 0)
            {
                pos = mid;
                end = mid - 1;
            }
            else
                beg = mid + 1;
        }
        return pos;
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) 
    {
        List<List<String>> ans = new ArrayList<>();
        int n = searchWord.length();
        Arrays.sort(products);
        for(int i=1; i<=n; i++)
        {
            String s = searchWord.substring(0, i);
            List<String> list = new ArrayList<>();
            int pos = search(products, s);
            if(pos != -1)
            {
                int m = Math.min(products.length, pos + 3);
                for(int j=pos; j<m; j++)
                {
                    if(products[j].indexOf(s) == 0)
                        list.add(products[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}