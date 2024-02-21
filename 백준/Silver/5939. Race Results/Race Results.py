import sys
from heapq import heappush, heappop

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def answer(self):
        N = int(self.input())
        heap = []

        for _ in range(N):
            hour, minute, sec = map(int, self.input().split())
            heappush(heap, (hour, minute, sec))

        while heap:
            h, m, s = heappop(heap)
            self.output(str(h)+' '+ str(m)+' '+ str(s) + ' \n')

s = Solution()
s.answer()