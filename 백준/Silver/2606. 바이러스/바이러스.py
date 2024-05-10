import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
        self.input_data = {}
        self.visited = []
        self.n = 0
        self.res = 0

    def answer(self, start):
        self.visited[start] = True

        for n in self.input_data[start]:
            if not self.visited[n]:
                self.res += 1
                self.answer(n)

    def run(self):
        N = int(self.input().rstrip())
        self.n = N

        for i in range(1, N+1):
            self.input_data[i] = []

        self.visited = [False] * (N+1)

        for _ in range(int(self.input().rstrip())):
            a,b = map(int,self.input().split(' '))
            self.input_data[a].append(b)
            self.input_data[b].append(a)

        self.answer(1)
        self.output(str(self.res) + '\n')

s = Solution()
s.run()