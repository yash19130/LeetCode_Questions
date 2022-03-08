class Solution 
{
    public int maxIceCream(int[] costs, int coins) 
    {
        Arrays.sort(costs);
        int cnt = 0;
        for(int i: costs)
        {
            if(i > coins)
                break;
            cnt++;
            coins -= i;
        }
        return cnt;
    }
}