# https://www.acmicpc.net/problem/14503
# 3:31~4:10

from collections import deque


def solution():
    n, m = map(int, input().split())
    r, c, d = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]

    ds = ((-1, 0), (0, 1), (1, 0), (0, -1))
    s = deque([(r, c)])
    count = 0
    while len(s) > 0:
        x, y = s.pop()
        if board[x][y] == 0:
            board[x][y] = 2
            count += 1

        is_all_clean = True
        for dx, dy in ds:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == 0:
                is_all_clean = False
                d = (d + 3) % 4
                break

        if not is_all_clean:
            nx = x + ds[d][0]
            ny = y + ds[d][1]
            if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == 0:
                s.append((nx, ny))
            else:
                s.append((x, y))
        else:
            nx = x - ds[d][0]
            ny = y - ds[d][1]
            if 0 <= nx < n and 0 <= ny < m and board[nx][ny] != 1:
                s.append((nx, ny))
            else:
                break

    return count


print(solution())
