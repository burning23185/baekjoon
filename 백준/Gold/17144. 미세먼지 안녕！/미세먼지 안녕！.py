import sys
from collections import deque 

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
        self.spread_way = ((-1,0), (0,1), (1,0), (0,-1))
    
    def findSpreadable(self, room_air: list):
        """ 확산 가능한 먼지덩어리를 큐로 반환
        Queue:{ ( x위치, y 위치, 먼지량 )}
        """
        queue = deque()
        for x, row in enumerate(room_air):
            for y, val in enumerate(row):
                if val // 5 > 0:
                    queue.append((x, y, val))
        return queue

    def spreadDust(self, room_air: list, queue: deque):
        """ 먼지 확산
        """
        
        while queue:
            x, y, val = queue.popleft()
                
            for way in self.spread_way:
                next_x = x + way[0]
                next_y = y + way[1]

                if next_x < 0 or next_y < 0 or next_x >= len(room_air) or next_y >= len(room_air[0]):
                    continue

                if room_air[next_x][next_y] == -1:
                    continue
                
                spread_amonut = val // 5
                room_air[next_x][next_y] += spread_amonut
                room_air[x][y] -= spread_amonut

        return room_air
    
    def rotateCounterClockwise(self, data_list, idx):

        for i in range(idx-1, 0, -1):
            data_list[i][0] = data_list[i-1][0]

        data_list[0] = data_list[0][1:] + [0]

        for i in range(1, idx+1):
            data_list[i-1][-1] = data_list[i][-1]

        data_list[idx] = [-1, 0] + data_list[idx][1:-1]

    def rotateClockwise(self, data_list, idx):

        for i in range(idx+1, len(data_list)-1, 1):
            data_list[i][0] = data_list[i+1][0]

        data_list[len(data_list)-1] = data_list[len(data_list)-1][1:] +[0]

        for i in range(len(data_list)-1, idx, -1):
            data_list[i][-1] = data_list[i-1][-1]

        data_list[idx] = [-1, 0] + data_list[idx][1:-1]
    
    def airPurification(self, room_air: list, dev_location : list):
        self.rotateCounterClockwise(room_air, dev_location[0])
        self.rotateClockwise(room_air, dev_location[1])

    def run(self):
        R, C, T = map(int, self.input().split())
        room_air  = []
        device_location= []

        for i in range(R):
            temp = []
            for val in self.input().rstrip().split():
                n = int(val)
                temp.append(n)

                if n == -1:
                    device_location.append(i)

            room_air.append(temp)

        for i in range(T):
            self.airPurification(self.spreadDust(room_air, self.findSpreadable(room_air)), device_location)
        ans = 0
        
        for i in room_air:
            ans += sum(i)

        ans += 2
        self.output(str(ans) + '\n')

s = Solution()
s.run()