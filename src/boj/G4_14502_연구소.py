# https://www.acmicpc.net/problem/14502
# 11:16~12:30, 7:36~7:55
from collections import deque


def main():
    n, m = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]

    virus = []
    s = deque()
    res = 0
    off = ((1, 0), (-1, 0), (0, 1), (0, -1))
    wall_count = 0
    min_v_count = 1000
    for i in range(n):
        for j in range(m):
            if board[i][j] == 2:
                virus.append((i, j))
            if board[i][j] == 1:
                wall_count += 1

    mark = 4
    for w1 in range(n * m):
        if board[w1 // m][w1 % m] in [1, 2]: continue
        for w2 in range(w1 + 1, n * m):
            if board[w2 // m][w2 % m] in [1, 2]: continue
            for w3 in range(w2 + 1, n * m):
                if board[w3 // m][w3 % m] in [1, 2]: continue
                walls = [(w // m, w % m) for w in [w1, w2, w3]]
                for w in walls:
                    board[w[0]][w[1]] = 1

                q = deque(virus)

                v_count = len(virus)
                while len(q) > 0:
                    if v_count > min_v_count:
                        v_count = 100
                        break
                    x, y = q.popleft()
                    for dx, dy in off:
                        nx = x + dx
                        ny = y + dy
                        if 0 <= nx < n and 0 <= ny < m:
                            if board[nx][ny] in [1, 2, mark]:
                                continue
                            q.append((nx, ny))
                            board[nx][ny] = mark
                            v_count += 1

                mark += 1

                zeros = n * m - wall_count - 3 - v_count
                res = max(res, zeros)
                for w in walls:
                    board[w[0]][w[1]] = 0

    print(res)


main()
