import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def run(self):
        n, k = map(int, self.input().split())
        items = [[0,0]]
        dp = [[0]*(k+1) for _ in range(n+1)]

        for _ in range(n):
            w, v = map(int, self.input().split())
            items.append([w, v])

        for i in range(1, n+1):
            for j in range(1, k+1):
                w = items[i][0]
                v = items[i][1]

                if j < w:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)

        self.output(f'{dp[n][k]}\n')

        
s = Solution()
s.run()