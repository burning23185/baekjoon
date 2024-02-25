import sys

class Solution:
    def __init__(self):
        self.input = sys.stdin.readline
        self.output = sys.stdout.write

    def deleteK(self, people, i ):
        temp = people[i]
        people[temp[0]]= (people[temp[0]][0], temp[1])
        people[temp[1]] = (temp[0], people[temp[1]][1])
        people.pop(i)
        return temp
    
    def run(self):
        n,k = map(int, sys.stdin.readline().split())
        
        if n == 1:
            sys.stdout.write('<1>\n')
            return
        
        people = {i : (i-1, i+1) for i in range(1, n+1)}
        people[1] = (n, 2)
        people[n] = (n-1, 1)
        res = []
        idx = 1
        val = 1

        while people:
            if idx == k:
                res.append(val)
                val = self.deleteK(people, val)[1]
                idx = 1
                continue


            val = people[val][1]
            idx += 1

        ans = '<' + ', '.join([str(i) for i in res]) + '>\n'
            
        sys.stdout.write(ans)

s = Solution()
s.run()