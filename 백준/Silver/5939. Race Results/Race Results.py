import sys
from collections import deque, defaultdict

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def answer(self):
        N = int(self.input())
        time_dict = defaultdict(list)

        for _ in range(N):
            hour, minute, sec = map(int, self.input().split())
            time_dict[hour].append((int(minute), int(sec)))
        
        for h, val in sorted(time_dict.items()):
            for m_s in sorted(val, key = lambda x :(x[0], x[1])):
                self.output(str(h)+' '+ str(m_s[0])+' '+ str(m_s[1]) + ' \n')

s = Solution()
s.answer()