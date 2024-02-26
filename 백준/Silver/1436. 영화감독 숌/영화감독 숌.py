import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def makeNum(self, res):
        temp = set()
        for i in range(10):
            for title in res:
                temp.add(str(i) + title)
                temp.add(title + str(i))
        return res | temp
    
    def run(self):
        n = int(self.input())
        res = set()
        res.add('666')

        while n >= len(res):
            res = self.makeNum(res)

        ans = sorted({int(i) for i in res})
        
        self.output(f'{ans[n-1]}\n')

s = Solution()
s.run()