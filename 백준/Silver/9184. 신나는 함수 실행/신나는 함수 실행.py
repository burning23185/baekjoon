import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
        self.dp = [[[0]*(21) for _ in range(21)] for _ in range(21)]

    def w(self, a, b, c):
        if a <= 0 or b <= 0 or c<= 0:
            return 1
            
        if a > 20 or b > 20 or c > 20:
            return self.w(20, 20, 20)
            
        if self.dp[a][b][c]:
            return self.dp[a][b][c]
            
        if a<b<c:
            self.dp[a][b][c] = self.w(a,b,c-1)+self.w(a,b-1,c-1)-self.w(a, b-1, c)
            return self.dp[a][b][c]
            
        self.dp[a][b][c] = self.w(a-1, b, c)+self.w(a-1,b-1,c)+self.w(a-1,b,c-1)-self.w(a-1,b-1,c-1)
        return self.dp[a][b][c]
            
    def run(self):
        a, b, c = map(int, self.input().split())

        while not (a == -1 and b == -1 and c == -1):
            self.output(f'w({a}, {b}, {c}) = {self.w(a,b,c)}\n')
            a, b, c = map(int, input().split())

s = Solution()
s.run()