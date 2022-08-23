class Solution 
{
    public int[] nextMinimum(int[] arr)
    {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] nextMin = new int[n];
        for(int i=n-1; i>=0; i--)
        {
            while(!s.isEmpty() && arr[s.peek()] > arr[i])
                s.pop();
            if(s.isEmpty())
                nextMin[i] = n - i;
            else
                nextMin[i] = s.peek() - i;
            s.push(i);
        }
        return nextMin;
    }
    
    public int[] previousMinimum(int[] arr)
    {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] prevMin = new int[n];
        for(int i=0; i<n; i++)
        {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();
            if(s.isEmpty())
                prevMin[i] = i + 1;
            else
                prevMin[i] = i - s.peek();
            s.push(i);
        }
        return prevMin;
    }
    
    public int sumSubarrayMins(int[] arr) 
    {
        int[] nextMin = nextMinimum(arr);
        int[] prevMin = previousMinimum(arr);
        int n = arr.length;
        int sum = 0;
        int mod = (int) 1e9 + 7;
        for(int i=0; i<n; i++)
        {
            sum += ((long) arr[i] * (long) nextMin[i] * (long) prevMin[i]) % mod;
            sum %= mod;
        }
        return sum;
    }
}