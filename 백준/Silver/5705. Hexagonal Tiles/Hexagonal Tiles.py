import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def answer(self):
        n = int(self.input())

        f = [0] * 41
        f[1] = 1
        f[2] = 2

        for i in range(3, 41):
            f[i] = f[i-2] + f[i-1]

        while n != 0:
            self.output(f'{f[n]}\n')
            n = int(self.input())

s = Solution()
s.answer()