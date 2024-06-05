import sys
from collections import deque

input = sys.stdin.readline
n, m = map(int, input().split())

board = [input().strip() for _ in range(n)]

start = ()
end = ()
ghosts = []
for i, s in enumerate(board):
    for j, _ in enumerate(s):
        if board[i][j] == 'N':
            start = (i, j)
        elif board[i][j] == 'G':
            ghosts.append((i, j))
        elif board[i][j] == 'D':
            end = (i, j)

is_visited = [[-1 for _ in range(m)] for _ in range(n)]

offsets = ((0, 1), (1, 0), (-1, 0), (0, -1))


def bfs(start):
    q = deque()
    q.append((start, 0))
    global is_visited, board
    is_visited[start[0]][start[1]] = 0
    while len(q) > 0:
        (cx, cy), depth = q.popleft()
        if board[cx][cy] == "D":
            return True

        for (ox, oy) in offsets:
            nx = cx + ox
            ny = cy + oy

            if nx not in range(n) or ny not in range(m) or is_visited[nx][ny] > -1 or board[nx][ny] == "#":
                continue
            is_visited[nx][ny] = depth + 1
            q.append(((nx, ny), depth + 1))

    return False


def ghost_dist(start):
    gx = abs(start[0] - end[0])
    gy = abs(start[1] - end[1])
    return gx + gy


if not bfs(start):
    print("No")
else:
    can_escape = True
    for g_pos in ghosts:
        gd = ghost_dist(g_pos)
        if gd <= is_visited[end[0]][end[1]]:
            can_escape = False
            break
    if can_escape:
        print("Yes")
    else:
        print("No")
