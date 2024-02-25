from heapq import heappop, heappush
import sys

def answer():
    heap = []
    res = ''
    data_list = [int(i) for i in sys.stdin.read().splitlines()][1:]
    for data in data_list:
        if data == 0:
            res += (str(heappop(heap)) if heap else '0')  + '\n'
        else:
            heappush(heap, data)

    print(res)

answer()