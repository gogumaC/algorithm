# https://www.acmicpc.net/problem/14499
# 4:27~6:00, 7:54~
from collections import deque


def main():
    n, m, x, y, k = map(int, input().split())

    maps = [list(map(int, input().split())) for _ in range(n)]
    hor = deque([0, 0, 0, 0])
    ver = deque([0, 0, 0, 0])
    if maps[x][y] != 0:
        hor[0] = maps[x][y]
        ver[3] = hor[0]
        maps[x][y] = 0

    moves = map(int, input().split())

    pos = [x, y]
    for m in moves:
        move(pos, hor, ver, m, maps)


off = (0, (0, 1), (0, -1), (-1, 0), (1, 0))


def move(pos, hor, ver, move, maps):
    dx, dy = off[move]
    x, y = pos
    if not (0 <= x + dx < len(maps) and 0 <= y + dy < len(maps[0])):
        return
    if move == 1 or move == 2:
        if move == 1:
            hor.appendleft(hor.pop())
        if move == 2:
            hor.append(hor.popleft())
        ver[1] = hor[2]
        ver.pop()
        ver.append(hor[0])
    elif move == 3 or move == 4:
        if move == 3:
            ver.append(ver.popleft())
        if move == 4:
            ver.appendleft(ver.pop())
        hor[2] = ver[1]
        hor.popleft()
        hor.appendleft(ver[3])

    if maps[x + dx][y + dy] == 0 and hor[0] != 0:
        maps[x + dx][y + dy] = hor[0]
    elif maps[x + dx][y + dy] != 0:
        hor[0] = maps[x + dx][y + dy]
        ver[3] = hor[0]
        maps[x + dx][y + dy] = 0

    pos[0] += dx
    pos[1] += dy
    print(hor[2])


main()
