class Solution 
{
    public int maxProduct(String[] words) 
    {
        int n = words.length;
        int maxP = 0;
        Map<String, String> hp = new HashMap<>();
        for(String w: words)
        {
            int[] cnt = new int[26];
            for(char c: w.toCharArray())
                cnt[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++)
                sb.append(cnt[i] + " ");
            hp.put(w, sb.toString());
        }
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                String s1 = hp.get(words[i]);
                String s2 = hp.get(words[j]);
                boolean shareCommon = false;
                for(int k=0; k<52; k+=2)
                {
                    if(s1.charAt(k) != '0' && s2.charAt(k) != '0')
                    {
                        shareCommon = true;
                        break;
                    }
                }
                if(!shareCommon)
                    maxP = Math.max(maxP, words[i].length() * words[j].length());
            }
        }
        return maxP;
    }
}