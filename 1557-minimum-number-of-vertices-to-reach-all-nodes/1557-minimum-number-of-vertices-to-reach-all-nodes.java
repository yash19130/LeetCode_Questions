class Solution 
{
    public List<Integer> findSmallestSetOfVertices(int n, 
                                                   List<List<Integer>> edges) 
    {
        boolean[] canReach = new boolean[n];
        for(List<Integer> edge: edges)
            canReach[edge.get(1)] = true;
        List<Integer> vertices = new ArrayList<>();
        for(int i=0; i<n; i++)
            if(!canReach[i])
                vertices.add(i);
        return vertices;
    }
}