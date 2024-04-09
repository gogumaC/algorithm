# https://www.acmicpc.net/problem/14500
# 11:17~12:07 9:58~11:23

def main():
    t1 = ((0, 0), (1, 0), (2, 0), (3, 0))
    t2 = ((0, 0), (1, 0), (0, 1), (1, 1))
    t3 = ((0, 0), (1, 0), (2, 0), (2, 1))
    t4 = ((0, 0), (1, 0), (1, 1), (2, 1))
    t5 = ((0, 0), (0, 1), (0, 2), (1, 1))
    ts = [t1, t2, t3, t4, t5]
    off = ((1, -1), (1, 1), (-1, -1), (-1, 1))
    n, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in
           range(n)]
    res = 0
    for i in range(n):
        for j in range(m):
            for t in ts:
                for mx, my in off:

                    if len([0 for dx, dy in t if 0 <= i + dx * mx < n and 0 <= j + dy * my < m]) == 4:
                        res = max(res, sum([arr[i + dx * mx][j + dy * my] for dx, dy in t]))

                    if len([0 for dx, dy in t if 0 <= i + dy * my < n and 0 <= j + dx * mx < m]) == 4:
                        res = max(res, sum([arr[i + dy * my][j + dx * mx] for dx, dy in t]))

    print(res)


main()
