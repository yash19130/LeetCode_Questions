class Solution 
{
    public int jump(int[] nums) 
    {
        int jumps = 0;
        int n = nums.length;
        int farthestTillNow = 0, end = 0;
        for(int i=0; i<=n-2; i++)
        {
            farthestTillNow = Math.max(farthestTillNow, i + nums[i]);
            if(i == end)
            {
                jumps++;
                end = farthestTillNow;
            }
        }
        return jumps;
    }
}
/*
    [7,0,9,6,9,6,1,7,9,0,1,2,9,0,3]

0) farthestTillNow = Math.max(farthestTillNow, 0 + 7) = 7
    0 == end:
        jumps++
        end = farthestTillNow
1) farthestTillNow = Math.max(farthestTillNow, 1 + 0) = 7
    1 != end
2) farthestTillNow = Math.max(farthestTillNow, 2 + 9) = 11
    2 != end
3) farthestTillNow = Math.max(farthestTillNow, 3 + 6) = 11
...
7) farthestTillNow = Math.max(farthestTillNow, 7 + 7) = 14
    7 == end:
        jumps++;
        end = farthestTillNow
        
    [2,3,1,1,4]
0) farthestTillNow = Math.max(farthestTillNow, 0 + 2) = 2
    0 == end:
        jumps++;
        end = farthestTillNow
1) farthestTillNow = Math.max(farthestTillNow, 1 + 3) = 4
    1 != end
2) farthestTillNow = Math.max(farthestTillNow, 2 + 1) = 4
    2 == end:
        jumps++;
        end = farthestTillNow = 4
*/