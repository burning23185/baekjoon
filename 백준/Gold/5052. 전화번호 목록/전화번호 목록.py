import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def run(self):
        t = int(self.input())
        for _ in range(t):
            n = int(self.input())
            p_nums = []

            for _ in range(n):
                p_num = self.input().rstrip()
                p_nums.append(p_num)

            p_nums.sort()

            res = 'YES'
            for i in range(len(p_nums)-1):
                if p_nums[i] == p_nums[i+1][:len(p_nums[i])]:
                    res = 'NO'
                    break

            self.output( res + '\n')

s = Solution()
s.run()