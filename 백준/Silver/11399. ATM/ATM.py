import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def answer(self):
        n = int(self.input())
        times = [int(i) for i in self.input().rstrip().split()]
        times.sort()
        length = len(times)
        res = 0

        for i in times:
            res += i*length
            length -= 1

        self.output(str(res) + '\n')

s = Solution()
s.answer()