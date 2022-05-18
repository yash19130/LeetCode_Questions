class Solution:
    def criticalConnections(self, n, connections):
        used, tin, fup = [0]*n, [-1]*n, [-1]*n
        self.timer, ans = 0, []
        graph = defaultdict(list)
        
        def dfs(node, par = -1):
            used[node] = 1
            tin[node] = fup[node] = self.timer + 1
            self.timer += 1
            for child in graph[node]:
                if child == par: continue
                if used[child] == 1:
                    fup[node] = min(fup[node], tin[child])
                else:
                    dfs(child, node)
                    fup[node] = min(fup[node], fup[child])
                    if fup[child] > tin[node]: ans.append([node, child])
        
        for i, j in connections:
            graph[i].append(j)
            graph[j].append(i)
            
        for i in range(n):
            if not used[i]: dfs(i)
                
        return ans