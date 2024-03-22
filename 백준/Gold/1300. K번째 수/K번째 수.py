
import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def answer(self):
        n = int(self.input())
        k = int(self.input())

        start = 1
        end = n * n
        result = 0

        while start <= end:
            cnt = 0

            mid = (start + end) // 2

            for div in range(1, n + 1):
                cnt += min(mid // div, n)
            
            if cnt >= k:
                result = mid
                end = mid - 1
            else:
                start = mid + 1

        self.output(f'{result}\n')
        
s = Solution()
s.answer()