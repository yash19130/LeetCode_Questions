class Solution(object):
    def countVowelPermutation(self, n):
        a, e, i, o, u = 1, 1, 1, 1, 1
        while n > 1:
            a, e, i, o, u = e + i + u, a + i, e + o, i, i + o
            n -= 1
        return (a + e + i + o + u) % (10**9 + 7)