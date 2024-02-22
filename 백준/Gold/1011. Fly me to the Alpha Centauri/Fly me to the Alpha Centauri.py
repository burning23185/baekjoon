import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def answer(self):
        T = int(self.input())

        for _ in range(T):
            a, b = map(int, self.input().split())
            distance = b - a
            root = int(distance**(1/2))
            sqr = root ** 2

            if distance <= 3:
                self.output(str(distance) + '\n')
                continue

            if distance == sqr:
                self.output(str(2*root-1) + '\n')
                continue

            if root + sqr < distance:
                self.output(str(2*root+1) + '\n')
                continue

            self.output(str(2*root) + '\n')

s = Solution()
s.answer()