class Solution 
{
    public List<List<String>> findDuplicate(String[] paths) 
    {
        Map<String, List<String>> hp = new HashMap<>();
        for(String path: paths)
        {
            String[] s = path.split(" ");
            int n = s.length;
            for(int i=1; i<n; i++)
            {
                StringBuilder content = new StringBuilder();
                StringBuilder file = new StringBuilder();
                boolean openingBracket = false;
                for(char c: s[i].toCharArray())
                {
                    if(c == '(')
                    {
                        openingBracket = true;
                        continue;
                    }
                    if(c == ')')
                    {
                        openingBracket = false;
                        continue;
                    }
                    if(openingBracket)
                        content.append(c);
                    else
                        file.append(c);
                }
                String cur = content.toString();
                if(!hp.containsKey(cur))
                    hp.put(cur, new ArrayList<>());
                hp.get(cur).add(s[0] + "/" + file);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> v: hp.values())
        {
            if(v.size() > 1)
                ans.add(v);
        }
        return ans;
    }
}