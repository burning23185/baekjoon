
class Solution:

    def recFunc(self, n, start, end) :
        if n == 1 :
            print(start, end)
            return
        
        self.recFunc(n-1, start, 6-start-end) 
        print(start, end) 
        self.recFunc(n-1, 6-start-end, end) 

    def run(self):
        n = int(input())
        print(2**n-1)
        self.recFunc(n, 1, 3)
        
s = Solution()
s.run()