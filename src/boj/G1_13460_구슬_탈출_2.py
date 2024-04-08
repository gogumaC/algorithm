def main():
    n, m = map(int, input().split())
    board = [list(input()) for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                red = (i, j)
                board[i][j] = '.'
            if board[i][j] == 'B':
                blue = (i, j)
                board[i][j] = '.'

    for next_op in range(4):
        bt(red, blue, 1, next_op, n, m, board)

    print(-1 if min_t == 11 else min_t)


off = ((0, 1), (1, 0), (-1, 0), (0, -1))
min_t = 11


def bt(rp, bp, time, op, n, m, board):
    global min_t
    if time > 10 or time > min_t: return
    nr = rp[:]
    nb = bp[:]

    rs = False
    bs = False
    red_fall = False
    while not (rs and bs):
        if not rs or not red_fall:
            nr = [nr[i] + off[op][i] for i in range(len(nr))]
            if not (0 <= nr[0] < n and 0 <= nr[1] < m) or board[nr[0]][nr[1]] == "#" or nr[0] == nb[0] and nr[1] == nb[
                1]:
                nr[0] -= off[op][0]
                nr[1] -= off[op][1]
                rs = True
        if not bs:
            nb = [nb[i] + off[op][i] for i in range(len(nr))]
            if not (0 <= nb[0] < n and 0 <= nb[1] < m) or board[nb[0]][nb[1]] == "#" or (
                    not red_fall and nr[0] == nb[0] and nr[1] == nb[1]):
                nb[0] -= off[op][0]
                nb[1] -= off[op][1]
                bs = True

        if board[nb[0]][nb[1]] == 'O':
            return

        if board[nr[0]][nr[1]] == 'O':
            red_fall = True

    if red_fall:
        min_t = min(min_t, time)
        return

    for next_op in range(4):
        if next_op == op: continue
        bt(nr, nb, time + 1, next_op, n, m, board)


main()
