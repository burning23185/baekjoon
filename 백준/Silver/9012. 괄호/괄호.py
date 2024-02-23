import sys

def run():
    N = int(sys.stdin.readline())

    for _ in range(N):
        res = False
        stack = []
    
        for c in sys.stdin.readline().rstrip():
            if c == '(':
                stack.append('(')
                continue

            if not stack:
                sys.stdout.write('NO\n')
                res = True
                break

            stack.pop()

        if res:
            continue

        if stack:
            sys.stdout.write('NO\n')
            continue

        sys.stdout.write('YES\n')

run()