import sys

def isBalance(input_str):
    stack = []
    for c in input_str:
            if c == '(' or c == '[' :
                stack.append(c)
                continue

            if c == ')' or c == ']':
                if not stack:
                    return False

            if c == ')':
                if stack.pop() != '(':
                    return False 
            
            if c == ']' :
                if stack.pop() != '[':
                    return False 
                
    if stack:
        return False
    
    return True

def run():
    input_str = sys.stdin.readline().rstrip()

    while len(input_str) != 1 or input_str[0] != '.':
        res = 'yes' if isBalance(input_str.replace(' ','')) else 'no'
        sys.stdout.write(f'{res}\n')
        input_str = sys.stdin.readline().rstrip()

run()