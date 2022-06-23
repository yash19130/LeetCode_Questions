class Solution 
{
    public int scheduleCourse(int[][] courses) 
    {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        Queue<Integer> q = new PriorityQueue <>((a, b) -> (b - a));
        int time = 0;
        for(int[] c: courses) 
        {
            if(time + c[0] <= c[1]) 
            {
                q.add(c[0]);
                time += c[0];
            } 
            else if(!q.isEmpty() && q.peek() > c[0]) 
            {
                time += c[0] - q.poll();
                q.add(c[0]);
            }
        }
        return q.size();    
    }
}