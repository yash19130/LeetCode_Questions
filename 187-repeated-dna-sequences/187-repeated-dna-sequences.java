class Solution 
{
    public List<String> findRepeatedDnaSequences(String s) 
    {
        HashMap<String, Integer> hp = new HashMap<>();
        int n = s.length();
        for(int i=0; i<=n-10; i++)
        {
            String cur = s.substring(i, i+10);
            if(hp.containsKey(cur))
                hp.put(cur, hp.get(cur)+1);
            else
                hp.put(cur, 1);
        }
        List<String> ans = new ArrayList<>();
        for(String k: hp.keySet())
            if(hp.get(k) > 1)
                ans.add(k);
        return ans;
    }
}