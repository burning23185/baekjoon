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

        mid = len(arr) // 2
        L = arr[:mid]
        R = arr[mid:]

        return self._merge(self.mergeSort(L), self.mergeSort(R))

    def answer(self):
        N = int(self.input())
        res = []

        for _ in range(N):
            res.append(int(self.input()))
            
        self.output('\n'.join(str(i) for i in self.mergeSort(res)) + '\n')

s = Solution()
s.answer()