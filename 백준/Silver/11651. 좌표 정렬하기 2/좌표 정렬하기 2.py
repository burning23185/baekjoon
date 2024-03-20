
import sys
import heapq

class Solution:
    def __init__(self) -> None:
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def run(self):
        n = int(self.input())
        nums = []

        for _ in range(n):
            a, b = map(int, self.input().split())
            heapq.heappush(nums,(b, a))

        while nums:
            c, d = heapq.heappop(nums)
            self.output(f'{d} {c}\n')
        
s = Solution()
s.run()