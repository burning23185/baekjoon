import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def answer(self):
        n = int(self.input())
        distance = [int(i) for i in self.input().rstrip().split()]
        weight = [int(i) for i in self.input().rstrip().split()]
        
    # 가장 싼 기름값 계산
        res = 0
        min_weight = weight[0]
        for i in range(n-1):
            min_weight = min_weight if min_weight < weight[i] else weight[i]
            res += min_weight * distance[i]

        self.output(f'{res}\n')

s = Solution()
s.answer()