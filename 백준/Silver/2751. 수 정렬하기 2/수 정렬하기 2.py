import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def merge_sort(self, arr):

        #탈출 조건
        if len(arr) < 2:
            return arr

        pivot = len(arr) // 2
        left_arr = self.merge_sort(arr[:pivot])
        right_arr = self.merge_sort(arr[pivot:])

        merged_arr = []
        l_idx, r_idx = 0, 0

        """
        작은 수부터 병합된 리스트에 집어넣기
            1 4 5 // 1, 3, 8
            merged = []
            
            1 4 5 // x, 3, 8
            merged = [1]

            x 4 5 // x, 3, 8
            merged = [1,1]

            x 4 5 // x, x, 8
            merged = [1,1,3]

            x x 5 // x, x, 8
            merged = [1,1,3,4]

            x x x // x, x, 8
            merged = [1,1,3,4,5]

            x x x // x, x, x
            merged = [1,1,3,4,5,8]
        종료
        """ 

        while l_idx < len(left_arr) and r_idx < len(right_arr):
            if left_arr[l_idx] < right_arr[r_idx]:
                merged_arr.append(left_arr[l_idx])
                l_idx += 1
            else:
                merged_arr.append(right_arr[r_idx])
                r_idx += 1

        #왼쪽, 오른쪽 병합
        merged_arr += left_arr[l_idx:]
        merged_arr += right_arr[r_idx:]

        return merged_arr   

    def answer(self):
        N = int(self.input())
        res = []

        for _ in range(N):
            res.append(int(self.input()))
            
        self.output('\n'.join(str(i) for i in self.merge_sort(res)) + '\n')

s = Solution()
s.answer()