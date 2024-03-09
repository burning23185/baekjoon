import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def run(self):
        n  = int(self.input())

        prefix_sum = 0
        res = 0
        nums = []

        nums = [int(i) for i in self.input().split()]

        for i in sorted(nums):
            prefix_sum += i
            res += prefix_sum

        print(f'{res}\n')

s = Solution()
s.run()