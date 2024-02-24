import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def determination(self,lines,n,mid):
        res = 0
        for x in lines:
            res += x//mid
        return res >= n

    def answer(self):
        k, n = map(int, self.input().split())
        lines = []

        for _ in range(k):
            lines.append(int(self.input()))

        left, right, ans = 0, 2500000000, 0

        while left <= right:
            mid = (left + right) // 2

            if self.determination(lines, n, mid):
                ans = mid
                left = mid + 1
                continue

            right = mid - 1
        self.output(f'{ans}\n')

s = Solution()
s.answer()