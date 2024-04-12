# 5:06~

from heapq import heappush, heappop

N = M = P = C = D = 0
santa_state = []
score = []
santas = []
board = []
out_count = 0


def solution():
    global N, M, P, C, D, santa_state, score, santas, board, out_count
    N, M, P, C, D = map(int, input().split())
    r, c = map(lambda v: int(v) - 1, input().split())
    board = [[0 for _ in range(N)] for _ in range(N)]
    santas = [[0, 0] for _ in range(P)]
    santa_state = [0 for _ in range(P)]
    score = [0 for _ in range(P)]

    board[r][c] = -1
    for i in range(P):
        num, sr, sc = map(int, input().split())
        board[sr - 1][sc - 1] = num
        santas[num - 1] = [sr - 1, sc - 1]

    for t in range(M):

        # # 루돌프 턴
        rudolf_nr, rudolf_nc, r_dir = moveR(r, c)
        n_num = board[rudolf_nr][rudolf_nc]
        board[r][c] = 0
        r = rudolf_nr
        c = rudolf_nc
        board[r][c] = -1

        if n_num > 0:
            nr, nc = crashByRudolf(rudolf_nr, rudolf_nc, r_dir)
            score[n_num - 1] += C
            if not (0 <= nr < N and 0 <= nc < N):
                santa_state[n_num - 1] = -1
                out_count += 1
            else:
                santa_state[n_num - 1] = 2
                temp = board[nr][nc]
                setSantaLocation(nr, nc, n_num)

                if temp > 0:
                    crashSantas(nr, nc, temp, r_dir)
        # 산타턴
        for idx, santa in enumerate(santas):
            if 0 < santa_state[idx]:  # faint
                # santa_state[idx] -= 1
                continue
            elif santa_state[idx] == -1:  # out
                continue

            santa_num = idx + 1
            sr, sc, s_dir = moveS(santa, (r, c))

            board[santa[0]][santa[1]] = 0

            if not (0 <= sr < N and 0 <= sc < N):  # out
                santa_state[idx] = -1
                out_count += 1
            else:
                temp = board[sr][sc]

                if temp == -1:  # 루돌프랑 부딪힘
                    santa_state[idx] = 2
                    score[idx] += D
                    nr, nc = crashBySanta(sr, sc, s_dir)
                    if not (0 <= nr < N and 0 <= nc < N):
                        santa_state[idx] = -1
                        out_count += 1
                    else:
                        santa_state[idx] = 2
                        temp = board[nr][nc]
                        setSantaLocation(nr, nc, santa_num)

                        if temp > 0:
                            crashSantas(nr, nc, temp, [-d for d in s_dir])
                else:
                    setSantaLocation(sr, sc, santa_num)

        # 턴별 점수 계산
        for i in range(P):
            if santa_state[i] == -1:
                continue
            if 0 < santa_state[i]:  # faint
                santa_state[i] -= 1
            score[i] += 1

        if out_count == P:
            return score

    return score


def setSantaLocation(r, c, num):
    board[r][c] = num
    santas[num - 1] = (r, c)


def moveR(r, c):
    pq = []
    # 가장 가까운 산타 찾기
    # rd = ((1, 1), (1, 0), (1, -1), (0, 1), (0, -1), (-1, 1), (-1, 0), (-1, -1))
    for i in range(N):
        for j in range(N):
            if board[i][j] > 0:
                heappush(pq, ((i - r) ** 2 + (j - c) ** 2, -i, -j, i, j))
    s = heappop(pq)[3:]

    # 이동할 방향 결정
    d = [0, 0]
    if s[0] != r:
        d[0] = (s[0] - r) // abs(s[0] - r)
    if s[1] != c:
        d[1] = (s[1] - c) // abs(s[1] - c)

    # 루돌프 이동 위치
    nr = r + d[0]
    nc = c + d[1]

    return nr, nc, d


def moveS(santa, rudolf):
    sd = ((-1, 0), (0, 1), (1, 0), (0, -1), (0, 0))
    sr, sc = santa
    rr, rc = rudolf

    pq = []
    heappush(pq, ((rr - sr) ** 2 + (rc - sc) ** 2, 4))
    # 루돌프와의 최단거리 방향 찾기
    for i in range(4):
        dr, dc = sd[i]
        nr = sr + dr
        nc = sc + dc
        if 0 <= nr < N and 0 <= nc < N and not board[nr][nc] > 0:
            heappush(pq, ((rr - nr) ** 2 + (rc - nc) ** 2, i))
    dir = sd[heappop(pq)[1]]
    nr = sr + dir[0]
    nc = sc + dir[1]
    return nr, nc, dir


def crashBySanta(r, c, dir):
    nr = r - dir[0] * D
    nc = c - dir[1] * D
    return nr, nc


def crashByRudolf(r, c, dir):
    nr = r + dir[0] * C
    nc = c + dir[1] * C
    return nr, nc


def crashSantas(r, c, num, dir):
    nr = r + dir[0]
    nc = c + dir[1]
    global out_count

    if not (0 <= nr < N and 0 <= nc < N):  # out
        santa_state[num - 1] = -1
        out_count += 1
        return

    n_num = board[nr][nc]
    setSantaLocation(nr, nc, num)

    if n_num > 0:
        crashSantas(nr, nc, n_num, dir)


print(" ".join(list(map(str, solution()))))
