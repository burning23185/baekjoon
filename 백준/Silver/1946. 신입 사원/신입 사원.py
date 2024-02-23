import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def answer(self):
        t = int(self.input())

        for _ in range(t):
            n = int(self.input())
            applicants = []

            for _ in range(n):
                a, b = map(int, self.input().split())
                applicants.append((a, b))
            
            applicants.sort()
            max_score = applicants[0][1]
            res = 1

            if max_score == 1:
                res = 1

            else :
                for i in range(1,n):
                    if max_score > applicants[i][1]:
                        max_score = applicants[i][1]
                        res += 1

            self.output(f'{res}\n')

s = Solution()
s.answer()