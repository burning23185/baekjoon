def dfs(idx, temp_res = 0, temp_kal = 0):
    global res

    if temp_kal > L:
        return
    
    res = temp_res if res < temp_res else res

    if idx == N :
        return
    
    score, calorie = ingredients[idx]

def dfs(idx, temp_res = 0, temp_kal = 0):
    global res

    if temp_kal > L:
        return
    
    res = temp_res if res < temp_res else res

    if idx == N :
        return
    
    score, calorie = ingredients[idx]

    dfs(idx+1, temp_res + score, temp_kal + calorie)
    dfs(idx+1, temp_res, temp_kal)

T = int(input())

for test_case in range(1, T + 1):
    N, L = map(int, input().split())
    ingredients = [list(map(int, input().split())) for _ in range(N)]
    res = 0
    dfs(0)

    print("#{0} {1}".format(test_case, res))