import sys

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 7)

N, M = map(int, input().split())

S = input().strip()

tree = [[] for _ in range(N + 1)]

answer = 0

for _ in range(N - 1):
    u, v, c = input().split()
    u = int(u)
    v = int(v)
    tree[u].append((v, c))
    tree[v].append((u, c))

is_visited = [False for _ in range(N + 1)]
dp = [[0 for _ in range(len(S) + 1)] for _ in range(N)]  # 반대 순서 쓰면 아래 로직 특성상 공간 지역성이 구려져 실행시간이 두배 차이나므로 반드시 순서를 고려해야함!


def dfs(u, track):
    global answer
    depth = len(track)
    if depth > 0:
        for i, ss in enumerate(S):
            tt = track[-1]
            if ss == tt:
                dp[depth][i + 1] = dp[depth - 1][i] + 1
            else:
                dp[depth][i + 1] = max(dp[depth - 1][i + 1], dp[depth][i])

        if len(tree[u]) == 1:
            answer = max(answer, dp[depth][len(S)])
            return
    for v, c in tree[u]:
        if is_visited[v]: continue
        is_visited[v] = True
        dfs(v, track + c)


def solution():
    global answer
    is_visited[1] = True
    dfs(1, "")
    print(answer)


solution()
