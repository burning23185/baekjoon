import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write
    
    def _merge(self, arr1, arr2):
        """오름차순으로 정렬하며 두개의 배열을 병합
        """
        
        result = []
        i = j = 0

        while i < len(arr1) and j < len(arr2):
            if arr1[i] < arr2[j]:
                result.append(arr1[i])
                i += 1
            else:
                result.append(arr2[j])
                j += 1

        # 왼쪽과 오른쪽의 배열의 크기가 다른 경우 남은 원소 결과에 추가

        while i < len(arr1):
            result.append(arr1[i])
            i += 1

        while j < len(arr2):
            result.append(arr2[j])
            j += 1

        return result
    
    def mergeSort(self, arr):
        """pivot 을 중간으로 설정하고 \n
        오름차순으로 병합 정렬
        """
        
        if len(arr) <= 1:
            return arr
        
        pivot = len(arr)//2

        L = arr[:pivot]
        R = arr[pivot:]

        return self._merge(self.mergeSort(L), self.mergeSort(R))

    def answer(self):
        N = int(self.input())
        data_dict = {}

        for _ in range(N):
            idx, val = self.input().split()
            i = int(idx)
            if i in data_dict:
                data_dict[i].append(val)
                continue

            data_dict[i] = [val]

        for i in self.mergeSort(list(data_dict.keys())):
            for name in data_dict[i]:
                self.output(f'{i} {name} \n')

s = Solution()
s.answer()