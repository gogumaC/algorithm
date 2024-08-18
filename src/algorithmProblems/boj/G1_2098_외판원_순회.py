N = 0
board = []
is_visited = []
dp = []
INF = 9887654321


def solution():
    global N, board, is_visited, dp
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    dp = [[-1 for _ in range(1 << N)] for _ in range(N)]

    return dfs(0, 1)


def dfs(current, visited):
    if visited == (1 << N) - 1:
        if board[current][0] > 0:
            return board[current][0]
        else:
            return INF

    if dp[current][visited] != -1:
        return dp[current][visited]
    dp[current][visited] = INF

    for next in range(N):
        if board[current][next] == 0: continue
        if (1 << next) & visited != 0: continue
        dp[current][visited] = min(dp[current][visited], board[current][next] + dfs(next, visited | (1 << next)))

    return dp[current][visited]


print(solution())
