class Solution 
{
    public List<Integer> partitionLabels(String s) 
    {
        int n = s.length();
        int[] alph = new int[26];
        for(int i=0; i<n; i++)
            alph[s.charAt(i) - 'a'] = i;
        List<Integer> partitions = new ArrayList<>();
        int i = 0;
        while(i < n)
        {
            int limit = alph[s.charAt(i) - 'a'];
            int j = i+1;
            while(j <= limit)
                limit = Math.max(limit, alph[s.charAt(j++) - 'a']);
            partitions.add(j-i);
            i = j;
        }
        return partitions;
    }
}