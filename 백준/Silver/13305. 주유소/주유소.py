import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def answer(self):
        n = int(self.input())
        distance = [int(i) for i in self.input().rstrip().split()]
        weight = [int(i) for i in self.input().rstrip().split()]

    #마지막 지점을 제외하고 기름값이 가장 싼 장소 찾기 및 거리 총합 계산
        min_weight = sys.maxsize
        remain_dis = 0
        for i in range(n-1):
            min_weight = min_weight if min_weight < weight[i] else weight[i]
            remain_dis += distance[i]

    # 가장 싼 기름값 계산
        res = 0
        for i in range(n):
            if weight[i] == min_weight:
                res += min_weight * remain_dis
                break

            res += weight[i] * distance[i]
            remain_dis -= distance[i]

        self.output(f'{res}\n')

s = Solution()
s.answer()