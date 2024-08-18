from collections import deque


def main():
    n, m = map(int, input().split())
    board = [list(input()) for _ in range(n)]
    red = [-1, -1]
    blue = [-1, -1]
    isVisited = {}
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                red = [i, j]
                board[i][j] = '.'
            if board[i][j] == 'B':
                blue = [i, j]
                board[i][j] = '.'

    q = deque([(red, blue, 9, 1)])

    while len(q) > 0:
        red, blue, prev_op, count = q.popleft()

        for i in range(4):
            nr, nb = move(board, red, blue, i)
            # print(nr, nb)
            if board[nb[0]][nb[1]] == 'O':
                continue
            if board[nr[0]][nr[1]] == 'O':
                print(count)
                return
            elif count < 10 and not (*nr, *nb) in isVisited:
                q.append((nr, nb, i, count + 1))
                isVisited[(*nr, *nb)] = True

    print(-1)


dx = (0, 0, 1, -1)
dy = (1, -1, 0, 0)


def move(board, red, blue, op):
    nr = red[:]
    nb = blue[:]
    red_stuck = False
    blue_stuck = False

    while not red_stuck or not blue_stuck:
        if not red_stuck:
            nr[0] += dx[op]
            nr[1] += dy[op]
            if board[nr[0]][nr[1]] == 'O':
                red_stuck = True
            elif nr == nb:
                nr[0] -= dx[op]
                nr[1] -= dy[op]
                if blue_stuck: red_stuck = True
            elif board[nr[0]][nr[1]] == '#':
                red_stuck = True
                nr[0] -= dx[op]
                nr[1] -= dy[op]
        if not blue_stuck:
            nb[0] += dx[op]
            nb[1] += dy[op]
            if board[nb[0]][nb[1]] == 'O':
                blue_stuck = True
            elif board[nb[0]][nb[1]] == '#' or (nr[0] == nb[0] and nr[1] == nb[1]):
                blue_stuck = True
                nb[0] -= dx[op]
                nb[1] -= dy[op]

    return (nr, nb)


main()
