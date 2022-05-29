class Solution 
{
    public int maxProduct(String[] words) 
    {
        int n = words.length;
        int maxP = 0;
        Map<String, int[]> hp = new HashMap<>();
        for(String w: words)
        {
            int[] cnt = new int[26];
            for(char c: w.toCharArray())
                cnt[c - 'a']++;
            hp.put(w, cnt);
        }
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int[] cnt1 = hp.get(words[i]);
                int[] cnt2 = hp.get(words[j]);
                boolean shareCommon = false;
                for(int k=0; k<26; k++)
                {
                    if(cnt1[k] > 0 && cnt2[k] > 0)
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