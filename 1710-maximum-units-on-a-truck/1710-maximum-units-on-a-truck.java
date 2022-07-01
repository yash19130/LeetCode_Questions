class Solution 
{
    public int maximumUnits(int[][] boxTypes, int truckSize) 
    {
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
        int i = 0, n = boxTypes.length;
        int boxes = 0;
        while(truckSize > 0 && i < n)
        {
            if(boxTypes[i][0] > truckSize)
                boxes += truckSize * boxTypes[i][1];
            else
                boxes += boxTypes[i][0] * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
            i++;
        }
        return boxes;
    }
}