class ThroneInheritance 
{
    String king;
    Map<String, List<String>> hp;
    Set<String> deceased;
    
    public ThroneInheritance(String kingName) 
    {
        this.king = kingName;
        this.hp = new HashMap<>();
        this.deceased = new HashSet<>();
        hp.put(king, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) 
    {
        if(hp.containsKey(parentName))
            hp.get(parentName).add(childName);
        else
        {
            List<String> children = new ArrayList<>();
            children.add(childName);
            hp.put(parentName, children);
        }
    }
    
    public void death(String name) 
    {
        deceased.add(name); 
    }
    
    public List<String> getInheritanceOrder() 
    {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }
    
    public void dfs(String member, List<String> order)
    {
        if(!deceased.contains(member))
            order.add(member);
        if(!hp.containsKey(member))
            return;
        for(String c: hp.get(member))
            dfs(c, order);
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */