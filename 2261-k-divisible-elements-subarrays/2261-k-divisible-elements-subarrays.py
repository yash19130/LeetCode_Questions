class Solution(object):
    def countDistinct(self, a, k, p):
        n = len(a)
        s = set()
        for i in range(n):
            for j in range(i, n):
                s.add(tuple(a[i : j + 1]))
        ans = 0
        for t in s:
            divByK = 0
            for i in t:
                if i % p == 0:
                    divByK += 1
            if divByK <= k:
                ans += 1
        return ans