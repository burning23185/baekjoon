import sys

def run():
    n = int(sys.stdin.readline())
    stack = []
    answer =''
    cur = 1
    res = False

    for _ in range(n):
        num = int(sys.stdin.readline())

        while cur <= num:
            stack.append(cur)
            answer += '+\n'
            cur += 1

        if stack[-1] == num:
            stack.pop()         
            answer += '-\n'
            continue
            
        sys.stdout.write('NO\n')
        res = True       
        break

    if not res:
        sys.stdout.write(f'{answer}\n')
run()
