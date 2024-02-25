from heapq import heappop, heappush
import sys

def answer():
    heap = []
    res = ''

    for data in [int(i) for i in sys.stdin.read().splitlines()][1:]:
        if data == 0:
            res += (str(-heappop(heap)) if heap else '0')  + '\n'
            continue
        
        heappush(heap, -data)

    print(res)

answer()