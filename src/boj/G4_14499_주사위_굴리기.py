# https://www.acmicpc.net/problem/14499
# 4:27~6:00, 7:54~8:27
# 8:19~8:39

def main():
    n, m, x, y, k = map(int, input().split())

    board = [list(map(int, input().split())) for _ in range(n)]

    ops = list(map(int, input().split()))

    dice = [0] * 6
    d = ((0, 1), (0, -1), (-1, 0), (1, 0))
    for op in ops:
        dx, dy = d[op - 1]
        x += dx
        y += dy
        if not (0 <= x < n and 0 <= y < m):
            x -= dx
            y -= dy
            continue
        dice = move(dice, op)

        if board[x][y] == 0:
            board[x][y] = dice[5]
        else:
            dice[5] = board[x][y]
            board[x][y] = 0
        print(dice[0])


def move(dice, op):
    a, b, c, d, e, f = dice
    if op == 1:
        dice = [d, b, a, f, e, c]  # 421653
    elif op == 2:
        dice = [c, b, f, a, e, d]  # 326154
    elif op == 3:
        dice = [e, a, c, d, f, b]  # 513462
    elif op == 4:
        dice = [b, f, c, d, a, e]  # 263415
    return dice


main()
