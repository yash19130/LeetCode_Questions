class Solution 
{
    public int numberOfWeakCharacters(int[][] properties) 
    {
        Arrays.sort(properties, (a, b) -> 
        {
            if(a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });
        int n = properties.length;
        int maxAttack = properties[0][0], maxDefense = properties[0][1];
        int weak = 0;
        for(int i=1; i<n; i++)
        {
            if(properties[i][0] < maxAttack && properties[i][1] < maxDefense)
                weak++;
            else
            {
                maxAttack = properties[i][0];
                maxDefense = properties[i][1];
            }
        }
        return weak;
    }
}