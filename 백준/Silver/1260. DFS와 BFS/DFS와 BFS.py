import sys
from collections import deque

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
        self.dfs_visited = []
        self.bfs_visited = []
        self.dict = {}
    
    def dfs(self, start : int, res = '') -> str:
        res += str(start) + ' '
        self.dfs_visited[start] = True
            
        for next in self.dict[start]:
            if not self.dfs_visited[next]:
                res = self.dfs(next, res)

        return res

    def bfs(self, start : int) -> str:
        Q = deque()
        Q.append(start)
        res = str(start) + ' '
        self.bfs_visited[start] = True

        while Q :
            now = Q.popleft()
            for next in self.dict[now]:
                if not self.bfs_visited[next]:
                    res += str(next) + ' '
                    Q.append(next)
                    self.bfs_visited[next] = True

        return res
        
    def run(self):
        N, M, V = map(int, self.input().split(' '))
        self.dict = { i : [] for i in range(1, N+1)}
        self.dfs_visited = [False] * (N + 1)
        self.bfs_visited = [False] * (N + 1)
        
        for _ in range(M):
            a,b = map(int,self.input().split(' '))
            self.dict[a].append(b)
            self.dict[b].append(a)

        for values in self.dict.values():
            values.sort()

        self.output(self.dfs(V) + '\n')
        self.output(self.bfs(V) + '\n')

s = Solution()
s.run()
