class Solution 
{
    public int maximumWealth(int[][] accounts) 
    {
        int m = accounts.length, n = accounts[0].length;
        int maxWealth = Integer.MIN_VALUE;
        for(int i=0; i<m; i++)
        {
            int ithWealth = 0;
            for(int j=0; j<n; j++)
                ithWealth += accounts[i][j];
            maxWealth = Math.max(maxWealth, ithWealth);
        }
        return maxWealth;
    }
}