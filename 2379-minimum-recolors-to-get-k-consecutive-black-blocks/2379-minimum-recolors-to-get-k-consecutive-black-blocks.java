class Solution 
{
    public int minimumRecolors(String blocks, int k) 
    {
        int n = blocks.length();
        int curBlack = 0;
        for(int i=0; i<k; i++)
        {
            if(blocks.charAt(i) == 'B')
                curBlack++;
        }
        int maxBlack = curBlack;
        for(int i=k; i<n; i++)
        {
             if(blocks.charAt(i) == 'B')
                curBlack++;
             if(blocks.charAt(i - k) == 'B')
                curBlack--;
            maxBlack = Math.max(maxBlack, curBlack);
        }
        return k - maxBlack;
    }
}