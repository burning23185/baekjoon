import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def findMaxAvailableNum(self, nums , k):
        left, right = 0 , len(nums) -1

        while left <= right:
            mid = (left + right)//2

            if nums[mid] <= k:
                left = mid +1

            else:
                right = mid -1

        return right

        
    def run(self):
        n, k = map(int, self.input().split())
        nums= []
        res = k
        ans = 0

        for _ in range(n):
            nums.append(int(self.input())) 
        
        i = self.findMaxAvailableNum(nums, k)

        while res > 0 and i >= 0:
            temp = res // nums[i]       
            res -= nums[i] * temp
            ans += temp
            i -= 1

        self.output(f'{ans}\n')

s = Solution()
s.run()