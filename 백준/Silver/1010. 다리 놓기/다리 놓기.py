import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def run(self):
        t = int(self.input())
        graph = [[0] * 30 for _ in range(30)]

        for i in range(30):
            for j in range(30):
                if i == 1:
                    graph[i][j] = j
                    continue

                if i == j:
                    graph[i][j] = 1
                    continue

                if i < j:
                        graph[i][j] = graph[i-1][j-1] + graph[i][j-1]

        for _ in range(t):
            n, m = map(int, self.input().split())
            self.output(f'{graph[n][m]}\n')

s = Solution()
s.run()