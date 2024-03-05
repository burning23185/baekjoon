import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def strSum(self, s : str):
        temp = 0
        for i in s.split('+'):
            temp += int(i)
        return temp
        
    def run(self):
        t = self.input().rstrip().split('-')
        res = self.strSum(t[0])

        for i in range(1, len(t)):
            res -= self.strSum(t[i]) 

        self.output(f'{res}\n')

s = Solution()
s.run()