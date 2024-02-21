import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def doMale(self, num, switches):
        for i in range(num-1, len(switches), num):
            switches[i] = 1 - switches[i]

    def doFemale(self, num, switches):

        start, end = num - 2, num
        switches[num-1] = 1- switches[num-1]

        while start >= 0 and end < len(switches):
            if switches[start] != switches[end]:
                break

            switches[start] = 1 - switches[start]
            switches[end] = 1 - switches[end]
            start -= 1
            end += 1


    def run(self):
        switch_num = int(self.input())
        switches = [int(i) for i in self.input().split()]
        student_num = int(self.input())
        
        for _ in range(student_num):
            gender, num = map(int, self.input().split())

            if gender == 1:
                self.doMale(num, switches)
                continue

            self.doFemale(num, switches)

        for idx, val in enumerate(switches):
            if idx != 0 and idx % 20 == 0:
                self.output('\n')
            self.output(str(val) + ' ')

        self.output('\n')

s = Solution()
s.run()