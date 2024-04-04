import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
        self.white = 0
        self.blue = 0
    
    def racFunc(self, arr):
        l = len(arr)
        s = sum(sum(row) for row in arr)

        if s == 0 or s == (l**2):
            if arr[0][0]:
                self.blue += 1
            else:
                self.white += 1
        else:
            self.racFunc([a[:l//2] for a in arr[:l//2]])
            self.racFunc([a[l//2:] for a in arr[:l//2]])
            self.racFunc([a[:l//2] for a in arr[l//2:]])
            self.racFunc([a[l//2:] for a in arr[l//2:]])

    def run(self):
        n = int(self.input())
        arr = [[int(i) for i in sys.stdin.readline().split()] for _ in range(n)]
      
        self.racFunc(arr)

        self.output(f'{self.white}\n')
        self.output(f'{self.blue}\n')

s = Solution()
s.run()