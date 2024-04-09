# 12:30~1:30

def main():
    n = int(input())
    tp = [tuple(map(int, input().split())) for _ in range(n)]
    tp = [(i, tp[i][0] + i - 1, tp[i][1]) for i in range(len(tp))]

    bt(0, 0, tp, 0, n)
    if tp[0][1] < n:
        bt(0, tp[0][2], tp, tp[0][1], n)
    print(m)


m = 0


def bt(day, sum, tp, last, n):
    global m
    if day == n:
        if sum > m:
            m = sum
        return

    bt(day + 1, sum, tp, last, n)
    if day > last and tp[day][1] < n:
        sum += tp[day][2]
        bt(day + 1, sum, tp, tp[day][1], n)


main()
