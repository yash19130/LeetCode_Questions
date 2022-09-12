class Solution 
{
    public int bagOfTokensScore(int[] tokens, int power) 
    {
        Arrays.sort(tokens);
        int score = 0, maxScore = 0;
        int i = 0, j = tokens.length - 1;
        while(i <= j)
        {
            if(power >= tokens[i])
            {
                power -= tokens[i++];
                score++;
                maxScore = Math.max(maxScore, score);
            }
            else if(score >= 1)
            {
                power += tokens[j--];
                score--;
            }
            else
                return 0;
        }
        return maxScore;
    }
}