import sys

input = sys.stdin.readline

dir = ((-1, 0), (1, 0), (0, -1), (0, 1))


def solution():
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    res = 0
    holes = {}

    for i in range(N):
        for j in range(N):
            if board[i][j] > 5:
                if board[i][j] not in holes:
                    holes[board[i][j]] = []
                holes[board[i][j]].append((i, j))

    for sr in range(N):
        for sc in range(N):
            for di in range(4):
                if board[sr][sc] != 0: continue
                res = max(res, moveBall(sr, sc, di, holes, board, N))

    return res


def moveBall(sr, sc, di, holes, board, N):
    cd = di
    dr, dc = dir[di]
    nr = sr
    nc = sc
    score = 0
    while True:
        nr += dr
        nc += dc
        if nr == sr and nc == sc:
            return score
        elif not (0 <= nr < N and 0 <= nc < N):
            cd = changeDir(5, cd)
            dr, dc = dir[cd]
            score += 1
        elif board[nr][nc] == -1:
            return score
        elif board[nr][nc] > 5:
            nr, nc = findWarmHall((nr, nc), board[nr][nc], holes)
            continue
        elif 0 < board[nr][nc] <= 5:
            cd = changeDir(board[nr][nc], cd)
            dr, dc = dir[cd]
            score += 1

    return score


def changeDir(type, cd):
    nd = cd
    if type == 1:
        if cd == 0:
            nd = 1
        elif cd == 1:
            nd = 3
        elif cd == 2:
            nd = 0
        elif cd == 3:
            nd = 2
    elif type == 2:
        if cd == 0:
            nd = 3
        elif cd == 1:
            nd = 0
        elif cd == 2:
            nd = 1
        elif cd == 3:
            nd = 2
    elif type == 3:
        if cd == 0:
            nd = 2
        elif cd == 1:
            nd = 0
        elif cd == 2:
            nd = 3
        elif cd == 3:
            nd = 1
    elif type == 4:
        if cd == 0:
            nd = 1
        elif cd == 1:
            nd = 2
        elif cd == 2:
            nd = 3
        elif cd == 3:
            nd = 0
    else:
        if cd == 0:
            nd = 1
        elif cd == 1:
            nd = 0
        elif cd == 2:
            nd = 3
        elif cd == 3:
            nd = 2
    return nd


def findWarmHall(start, num, holes):
    if holes[num][0] == start:
        return holes[num][1]
    else:
        return holes[num][0]


def main():
    T = int(input())
    for t in range(T):
        print('#', t + 1, " ", solution(), sep="")


main()
