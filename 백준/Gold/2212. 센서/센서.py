import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def answer(self):
        n = int(self.input())
        k = int(self.input())

        sensors = [int(i) for i in self.input().split()]
        sensors.sort()

        weight = []
        for i in range(len(sensors)-1):
            weight.append(sensors[i+1] - sensors[i])
        weight.sort()

        res = 0
        for i in range(n-k):
            res += weight[i]

        self.output(f'{res}\n')

s = Solution()
s.answer()