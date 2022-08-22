class Solution 
{
    public int GCD(int number1, int number2) 
    {
        if(number2 == 0)
            return number1;
        return GCD(number2, number1 % number2);
    }
    
    public int maxPoints(int[][] points) 
    {
        int n = points.length;
        if(n <= 2)
            return n;
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            Map<String, Integer> hp = new HashMap<>();
            for(int j=i+1; j<n; j++)
            {
                int[] curSlope = {points[i][1] - points[j][1], points[i][0] - points[j][0]};
                int g = GCD(curSlope[0], curSlope[1]);
                curSlope[0] /= g;
                curSlope[1] /= g;
                String slope = curSlope[0] + " " + curSlope[1];
                if(hp.containsKey(slope))
                    hp.put(slope, hp.get(slope) + 1);
                else
                    hp.put(slope, 2);
                ans = Math.max(ans, hp.get(slope));
            }
        }
        return ans;
    }
}