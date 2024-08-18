# 8:35
# 10:46

knights = []
board = []
damage = []
expired = []
L = N = Q = 0
d = ((-1, 0), (0, 1), (1, 0), (0, -1))


def solution():
    global L, N, Q, knights, board, damage, expired

    L, N, Q = map(int, input().split())

    board = [list(map(int, input().split())) for _ in range(L)]

    knights = [list(map(int, input().split())) for _ in range(N)]
    for k in range(N):
        knights[k][0] -= 1
        knights[k][1] -= 1

    damage = [0 for _ in range(N)]
    expired = [False for _ in range(N)]

    orders = [list(map(int, input().split())) for _ in range(Q)]

    for i, di in orders:
        dir = d[di]
        if expired[i - 1]: continue

        movable, connect, damaged = checkMovable(i - 1, dir)
        if not movable: continue
        move(connect, dir)

        calcDamge(connect, i - 1)

    sum = 0
    for i in range(N):
        if expired[i]: continue
        sum += damage[i]
    return sum


def calcDamge(damaged, ordered_k):
    for k in damaged:
        if k == ordered_k: continue
        if expired[k]: continue
        r, c, h, w, kk = knights[k]
        for i in range(r, r + h):
            for j in range(c, c + w):
                if board[i][j] == 1:
                    damage[k] += 1
        if damage[k] >= kk:
            expired[k] = True


def checkMovable(idx, dir):
    knight = knights[idx]

    ranges = []
    connect = [idx]
    damaged_c = set()
    for i in range(2):
        if dir[i] == 0:
            r = range(knight[i], knight[i] + knight[i + 2])
        elif dir[i] == -1:
            r = range(knight[i] - 1, knight[i])
        else:
            r = range(knight[i] + knight[i + 2], knight[i] + knight[i + 2] + 1)
        ranges.append(r)

    for i in ranges[0]:
        for j in ranges[1]:
            if not (0 <= i < L and 0 <= j < L) or board[i][j] == 2:
                return False, [], []

            if board[i][j] == 1:
                damaged_c.add(idx)

            for k in range(N):
                if k == idx: continue
                if expired[k]: continue
                if k in connect: continue
                kr, kc, kh, kw, _ = knights[k]

                if kr <= i <= kr + kh - 1 and kc <= j <= kc + kw - 1:
                    res, connected, damaged = checkMovable(k, dir)
                    if not res:
                        return False, [], []
                    else:
                        connect.extend(connected)
                        damaged_c.update(damaged)

    return True, connect, damaged_c


def move(connected, dir):
    for k in connected:
        r, c, h, w, _ = knights[k]

        knights[k][0] = r + dir[0]
        knights[k][1] = c + dir[1]


print(solution())
