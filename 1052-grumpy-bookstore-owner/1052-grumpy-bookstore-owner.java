class Solution 
{
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) 
    {
        int n = customers.length;
        int happy = 0;
        for(int i=0; i<n; i++)
        {
            if(grumpy[i] == 0)
                happy += customers[i];
        }
        int notGrumpy = 0;
        for(int i=0; i<minutes; i++)
        {
            if(grumpy[i] == 1)
                notGrumpy += customers[i];
        }
        int maxNotGrumpy = notGrumpy;
        for(int i=minutes; i<n; i++)
        {
            if(grumpy[i] == 1)
                notGrumpy += customers[i];
            if(grumpy[i-minutes] == 1)
                notGrumpy -= customers[i-minutes];
            maxNotGrumpy = Math.max(maxNotGrumpy, notGrumpy);
        }
        return happy + maxNotGrumpy;
    }
}