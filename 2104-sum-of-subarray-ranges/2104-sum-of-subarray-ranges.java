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
                nextMin[i] = n - i - 1;
            else
                nextMin[i] = s.peek() - i - 1;
            s.push(i);
        }
        return nextMin;
    }
    
    public int[] nextGreater(int[] arr)
    {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] nextMax = new int[n];
        for(int i=n-1; i>=0; i--)
        {
            while(!s.isEmpty() && arr[s.peek()] < arr[i])
                s.pop();
            if(s.isEmpty())
                nextMax[i] = n - i - 1;
            else
                nextMax[i] = s.peek() - i - 1;
            s.push(i);
        }
        return nextMax;
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
                prevMin[i] = i;
            else
                prevMin[i] = i - s.peek() - 1;
            s.push(i);
        }
        return prevMin;
    }
    
    public int[] previousGreater(int[] arr)
    {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] prevMax = new int[n];
        for(int i=0; i<n; i++)
        {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i])
                s.pop();
            if(s.isEmpty())
                prevMax[i] = i;
            else
                prevMax[i] = i - s.peek() - 1;
            s.push(i);
        }
        return prevMax;
    }
    
    public long sumSubarrayMins(int[] arr) 
    {
        int[] nextMin = nextMinimum(arr);
        int[] prevMin = previousMinimum(arr);
        int n = arr.length;
        long sum = 0;
        for(int i=0; i<n; i++)
        {
            sum += (long) arr[i] * (long) (nextMin[i]  + 1) * (long) (prevMin[i] + 1);
        }
        return sum;
    }
    
    public long sumSubarrayMaxs(int[] arr) 
    {
        int[] nextMax = nextGreater(arr);
        int[] prevMax = previousGreater(arr);
        int n = arr.length;
        long sum = 0;
        for(int i=0; i<n; i++)
        {
            sum += (long) arr[i] * (long) (nextMax[i]  + 1) * (long) (prevMax[i] + 1);
        }
        return sum;
    }
    
    public long subArrayRanges(int[] nums) 
    {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }
}