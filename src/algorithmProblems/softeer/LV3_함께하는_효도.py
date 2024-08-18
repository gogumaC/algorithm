n, m = map(int, input().split())
field = [list(map(int, input().split())) for _ in range(n)]
pos = [list(map(lambda x: int(x) - 1, input().split())) for _ in range(m)]
result = 0

for (x, y) in pos:
    result += field[x][y]
    field[x][y] = 0

offsets = ((0, 1), (0, -1), (1, 0), (-1, 0))


def dfs(current, depth, sum):
    global result
    if depth == 3 * m:
        result = max(result, sum)
        return
    cx, cy = current

    for i in range(m):
        if depth == 3 * i:
            cx, cy = pos[i]
            break

    for (ox, oy) in offsets:
        nx = cx + ox
        ny = cy + oy
        next = (nx, ny)

        if nx not in range(n) or ny not in range(n):
            continue
        get = field[nx][ny]
        field[nx][ny] = 0
        dfs(next, depth + 1, sum + get)
        field[nx][ny] = get


dfs(pos[0], 0, result)
print(result)
