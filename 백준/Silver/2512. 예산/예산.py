import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def determination(self, nums, target, mid):
        res = 0
        for n in nums:
                res += min(n, mid)
        return res <= target

    def answer(self):
        n = int(self.input())
        nums = [int(i) for i in self.input().split()]
        target = int(self.input())
        left, right, ans = 0, max(nums), 0
        
        while left <= right:
            mid = (left + right) // 2
            if self.determination(nums, target, mid):
                ans = mid
                left = mid + 1
                continue

            right = mid - 1

        self.output(f'{ans}\n')

s = Solution()
s.answer()