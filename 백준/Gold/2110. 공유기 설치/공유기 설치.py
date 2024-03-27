import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def determination(self, target, nums, c):
        cnt, last = 1, nums[0]
        for num in nums:
            if num - last < target:
                continue

            last = num
            cnt += 1
        return cnt >= c

    def run(self):
        nums = []
        n, c = map(int,self.input().split())
            
        for _ in range(n):
            nums.append(int(self.input()))

        nums.sort()
        left, right, ans = 0, 1000000000, 0

        while left <= right:
            mid = (left + right) // 2
            
            if self.determination(mid, nums, c):
                ans = mid
                left = mid + 1
                continue
            
            right = mid - 1

        self.output(f'{ans}\n')

s = Solution()
s.run()