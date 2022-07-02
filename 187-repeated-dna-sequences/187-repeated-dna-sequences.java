class Solution 
{
    public List<String> findRepeatedDnaSequences(String s) 
    {
        int n = s.length();
        if(n < 10)
            return new ArrayList<>();
        HashMap<String, Integer> hp = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++)
            sb.append(s.charAt(i));
        hp.put(sb.toString(), 1);
        for(int i=10; i<n; i++)
        {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            String cur = sb.toString();;
            hp.put(cur, hp.getOrDefault(cur, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for(String k: hp.keySet())
            if(hp.get(k) > 1)
                ans.add(k);
        return ans;
    }
}