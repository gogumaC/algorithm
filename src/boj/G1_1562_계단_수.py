N = 0
dp = []


def solution():
    global N, dp

    N = int(input())
    dp = [[[0 for _ in range(1 << 10)] for _ in range(N)] for _ in range(10)]
    count = 0
    for i in range(1, 10):
        dp[i][0][1 << i] = 1

    for depth in range(1, N):
        for current in range(10):
            for state in range(1 << 10):
                r1 = 0 if current == 0 else dp[current - 1][depth - 1][state]
                r2 = 0 if current == 9 else dp[current + 1][depth - 1][state]
                dp[current][depth][state | (1 << current)] += (r1 + r2)
                dp[current][depth][state | (1 << current)] %= 1000000000

    for i in range(10):
        count += dp[i][N - 1][(1 << 10) - 1]

        count %= 1000000000
    return count


print(solution())
