class Solution(object):
    def largestLocal(self, grid):
        n = len(grid)
        maxMat = [[0 for i in range(n - 2)] for j in range(n - 2)]
        dx = [-1, -1, -1, 1, 1, 1, 0, 0]
        dy = [0, 1, -1, 0, 1, -1, -1, 1]
        for i in range(1, n - 1):
            for j in range(1, n - 1):
                maxMat[i - 1][j - 1] = grid[i][j]
                for k in range(8):
                    maxMat[i - 1][j - 1] = max(maxMat[i - 1][j - 1], grid[i + dx[k]][j + dy[k]])
        return maxMat
        