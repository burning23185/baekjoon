import sys
import heapq

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def answer(self):
        v, e = map(int, self.input().split())
        k = int(self.input())
        edges = [[] for _ in range(v+1)]
        
        max_dist = 10*e + 1
        dist_arr = [max_dist] * (v+1)
        dist_arr[k] = 0

        for _ in range(e):
            cur, adj, weight = map(int, self.input().split())
            edges[cur].append((adj, weight))

        queue = []
        heapq.heappush(queue, (0, k))

        while queue:
            dis_cur, cur = heapq.heappop(queue)
            
            if dis_cur > dist_arr[cur]:
                continue

            for adj, weight in edges[cur]:
                temp = dis_cur + weight
                if dist_arr[adj] > temp:
                    dist_arr[adj] = temp
                    heapq.heappush(queue, (temp, adj))

        for i in range(1, v+1):
            res = 'INF' if dist_arr[i] == max_dist else str(dist_arr[i])
            self.output(f'{res}\n')

s = Solution()
s.answer()