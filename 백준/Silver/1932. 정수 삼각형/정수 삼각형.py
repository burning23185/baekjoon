import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def run(self):
        n = int(self.input())
        dp = []
        
        for i in range(n):
            dp.append(list(map(int,sys.stdin.readline().split())))
        
        for i in range(1,n):
            for j in range(i+1):
                if j==0:
                    dp[i][j]+=dp[i-1][j]
                elif j==i:
                    dp[i][j]+=dp[i-1][j-1]
                else:
                    dp[i][j] += max(dp[i - 1][j - 1], dp[i - 1][j])

        self.output(f'{max(dp[n-1])}\n')
        
s = Solution()
s.run()