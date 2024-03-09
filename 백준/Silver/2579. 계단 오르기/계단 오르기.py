import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def run(self):
        n  = int(self.input())

        nums = [0] * (n+1)
        dp = [0] * (n+1)

        for i in range(1, n+1):
            nums[i] = int(self.input())

        if n == 1:
            print(f'{nums[1]}\n')
            return 
        
        dp[1] = nums[1]
        dp[2] = nums[1] + nums[2]

        for i in range(3, n+1):
            dp[i] = max(dp[i-3] + nums[i-1] + nums[i], dp[i-2] + nums[i])

        print(f'{dp[n]}\n')

s = Solution()
s.run()