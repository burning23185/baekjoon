import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def answer(self):
        n = int(self.input())

        for _ in range(n):
            x1, y1, r1, x2, y2, r2 = map(int, self.input().split())
            dis = ((x1-x2)**2 + (y1-y2)**2)**(1/2)

            if dis == 0 and r1 == r2 :
                self.output('-1 \n')
                continue

            if dis == abs(r1-r2) or dis == r1 + r2:
                self.output('1 \n')
                continue

            if abs(r1-r2) < dis and dis < (r1+r2) :
                self.output('2 \n')
                continue

            self.output('0 \n') 

s = Solution()
s.answer()
