class Solution 
{
    public List<Integer> sequentialDigits(int low, int high) 
    {
        int seqBeg[] = {12, 123, 1234, 12345, 123456, 
                     1234567, 12345678, 123456789};
        int seqEnd[] = {89, 789, 6789, 56789, 456789, 
                        3456789, 23456789, 123456789};
        int n = seqBeg.length;
        List<Integer> ans = new ArrayList<>();
        int add = 11;
        for(int i=0; i<n; i++)
        {
            int cur = seqBeg[i];
            while(cur <= seqEnd[i])
            {
                if(cur > high)
                    break;
                if(cur >= low)
                    ans.add(cur);
                cur += add;
            }
            add = add*10 + 1;
        }
        return ans;
    }
}