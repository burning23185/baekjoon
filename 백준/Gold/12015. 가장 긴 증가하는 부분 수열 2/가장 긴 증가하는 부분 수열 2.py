import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def binary(self, num, dp):
        start,end = 0, len(dp)-1

        while True:
          if end-start < 2 and dp[end]<num:
            return end
        
          if end-start < 2:
            return start
        
          mid = (end+start)//2

          if dp[mid] == num:
            return mid-1
        
          if dp[mid] > num:
            end = mid
            continue
        
          start = mid


    def run(self):
        n = int(self.input())
        nums= map(int,self.input().split())
        dp = [0]
      
        for num in nums:
            l = self.binary(num, dp)+1

            if l > len(dp)-1:
              dp.append(num)
              continue

            if dp[l] > num:
              dp[l] = num

        self.output(f'{len(dp)-1}\n')

s = Solution()
s.run()