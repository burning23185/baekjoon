import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
        self.max_weight = sys.maxsize
    
    def prevMin(self, cur: int, color : tuple, weight : list) -> int:
        """현재 선택할 수 있는 최소값과 선택한 색깔의 index를 반환"""
        
        res = 1000000000+1

        for i in range(len(color)):
            if i == cur:
                continue

            if weight[i] < res:
                res = weight[i]

        return res

    def answer(self):
        n = int(self.input())
        
        color = ('R', 'G', 'B')
        dy = [[] * n for _ in range(n)]
        self.max_weight = 1000

        for i in range(n):
            r, g, b = map(int, self.input().split())
            dy[i] = [r, g, b]

        for i in range(1,n):
            for j in range(len(color)):
                dy[i][j]= self.prevMin(j, color, dy[i-1]) + dy[i][j]

        ans = min(dy[n-1][0], dy[n-1][1], dy[n-1][2])
        self.output(f'{ans}\n')

s = Solution()
s.answer()