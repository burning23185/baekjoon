import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def determination(self, trees, m, h):
        sum = 0
        for x in trees:
            if x > h:
                sum += x - h
        return sum >= m

    def answer(self):
        n, m = map(int, self.input().split())
        trees = [int(i) for i in self.input().split()]

        left, right, ans = 0, 2000000000, 0

        while left <= right:
            mid = (left + right) // 2
            
            if self.determination(trees, m, mid):
                #자를 수 있는 나무 길이 중 최소가 될때까지 실행
                ans = mid
                left = mid + 1
            else:
                right = mid - 1

        self.output(f'{ans}\n')
                
s = Solution()
s.answer()