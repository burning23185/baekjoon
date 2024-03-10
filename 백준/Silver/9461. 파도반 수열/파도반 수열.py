import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
            
    def run(self):
        dp = [0] * 101
        dp[1] = 1
        dp[2] = 1
        dp[3] = 1

        for i in range(4, 101):
            dp[i] = dp[i-2] + dp[i-3]

        for _ in range(int(self.input())):
            self.output(f'{dp[int(self.input())]}\n')

s = Solution()
s.run()