from collections import deque


def solution(n, wires):
    board = {}
    for a, b in wires:
        if a not in board:
            board[a] = []
        if b not in board:
            board[b] = []

        board[a].append(b)
        board[b].append(a)

    answer = 1000000000000
    for r1, r2 in wires:
        a = dfs(r1, r2, board, n) + 1
        b = len(board) - a
        answer = min(answer, abs(a - b))

    return answer


def dfs(r, cut, board, n):
    is_visited = [False for _ in range(len(board) + 1)]
    s = deque()
    s.append(r)
    is_visited[r] = True
    count = 0
    while len(s) > 0:
        current = s.pop()
        for n in board[current]:
            if not is_visited[n] and n != cut:
                s.append(n)
                is_visited[n] = True
                count += 1
    return count
