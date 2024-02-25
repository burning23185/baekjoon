import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
        self.nums = {}

    def dfs(self, val, target, dir, depth = 0):
        """ dir : 0 왼쪽 dir : 1 오른쪽 으로 탐색
        """
        # print(val, depth, nums)
        if val == target:
            return depth

        next = self.nums[val][0] if dir == 0 else self.nums[val][1]
        return self.dfs(next, target, dir, depth + 1)

    def popNum(self, nums, idx):
        now = nums[idx]
        if now[0] in nums and now[1] in nums:
            nums[now[0]] = (nums[now[0]][0], nums[idx][1])
            nums[now[1]] = (nums[idx][0], nums[now[1]][1])
        nums.pop(idx)
        return now[1]

    def run(self):
        n,m = map(int, sys.stdin.readline().split())
        nums = {i : (i-1, i+1) for i in range(1,n)}
        nums[1] = (n, 2)
        nums[n] = (n-1, 1)
        idx = 1
        res = 0
        self.nums = nums

        for target in [int (i) for i in sys.stdin.readline().split()]:

            if(idx == target):
                idx = self.popNum(self.nums, idx)
                continue

            left = self.dfs(idx, target, 0)
            right = self.dfs(idx, target, 1)

            temp = left > right
            res += right if temp else left

            idx = self.popNum(self.nums, target)

        sys.stdout.write(f'{res}\n')

s = Solution()
s.run()