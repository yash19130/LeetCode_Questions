class Solution(object):
    def findPaths(self, m, n, maxMove, startRow, startColumn):
        def solve(i, j, m, n, k, dp):
            if i < 0 or j < 0 or i >= m or j >= n:
                    return 1
            if k == 0:
                return 0
            idx = str(i) + " " + str(j) + " " + str(k)
            if idx in dp:
                return dp[idx]
            mod = int(10 ** 9) + 7
            dx = [0, 0, -1, 1]
            dy = [-1, 1, 0, 0]
            dp[idx] = 0
            for l in range(4):
                dp[idx] += solve(i + dx[l], j + dy[l], m, n, k - 1, dp) % mod
                dp[idx] %= mod
            return dp[idx]
        return solve(startRow, startColumn, m, n, maxMove, {})
