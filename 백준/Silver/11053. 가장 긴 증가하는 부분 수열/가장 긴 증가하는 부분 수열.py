import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def run(self):
        n = int(self.input())
        nums = [int(i) for i in self.input().split()]

        dp = [1] * n

        for i in range(1, n):
            for j in range(0, i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j]+1)

        self.output(f'{max(dp)}\n')

        
s = Solution()
s.run()