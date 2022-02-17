class Solution 
{
    public int[] asteroidCollision(int[] a) 
    {
        int n = a.length;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++)
        {
             if(a[i] < 0)
             {
                 boolean toBeAdded = true;
                 while(!s.isEmpty() && s.peek() > 0)
                 {
                     if(s.peek() + a[i] == 0)
                     {
                         toBeAdded = false;
                         s.pop();
                         break;
                     }
                     else if(s.peek() + a[i] < 0)
                         s.pop();
                     else
                     {
                         toBeAdded = false;
                         break;
                     }
                 }
                 if(toBeAdded)
                    s.push(a[i]);
             }
            else
                s.push(a[i]);
        }
        int[] ans = new int[s.size()];
        for(int i=s.size()-1; i>=0; i--)
            ans[i] = s.pop();
        return ans;
    }
}