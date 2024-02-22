import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def _merge(self, arr1, arr2):

        result = []
        i = j = 0

        while i < len(arr1) and j < len(arr2):
            if arr1[i] < arr2[j]:
                result.append(arr1[i])
                i += 1
            else:
                result.append(arr2[j])
                j += 1

        while i < len(arr1):
            result.append(arr1[i])
            i += 1

        while j < len(arr2):
            result.append(arr2[j])
            j += 1

        return result
    
    def mergeSort(self, arr):
        
        if len(arr) <= 1:
            return arr
        
        pivot = len(arr)//2

        L = arr[:pivot]
        R = arr[pivot:]

        return self._merge(self.mergeSort(L), self.mergeSort(R))
    
    def run(self):
        N = int(self.input())
        arr = []
        arr_dict = {}
        sum = 0
        max_cnt = 1

        for _ in range(N):
            n = int(self.input())
            arr.append(n)
            sum += n

            if n in arr_dict:
                arr_dict[n] += 1
                max_cnt = max_cnt if max_cnt > arr_dict[n] else arr_dict[n]
                continue
            arr_dict[n] = 1

        sorted_arr = self.mergeSort(arr)

        if len(arr) == 1:
            min_count_value = arr[0]
        else:
            temp = []
            for n in arr_dict:
                if arr_dict[n] == max_cnt:
                    temp.append(n)

            if max_cnt == 1:
                min_count_value = sorted_arr[1]
            elif len(temp) == 1:
                min_count_value = temp[0]
            else:
                min_count_value = self.mergeSort(temp)[1]
                
        self.output(str(round(sum/len(arr))) + '\n')
        self.output(str(sorted_arr[len(arr)//2]) + '\n')
        self.output(str(min_count_value) + '\n')
        self.output(str(sorted_arr[-1] - sorted_arr[0]) + '\n')

s = Solution()
s.run()