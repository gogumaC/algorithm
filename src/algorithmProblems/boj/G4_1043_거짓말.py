from collections import deque


def solution():
    N, M = map(int, input().split())
    t = list(map(int, input().split()))
    trues = t[1:]
    parties = [list(map(int, input().split()))[1:] for _ in range(M)]
    people = [[] for _ in range(N + 1)]

    for i in range(M):
        party = parties[i]
        for p in party:
            people[p].append(i)

    s = deque()
    can_bluf = [True for _ in range(M)]

    s.extend(trues)

    while len(s) > 0:
        t = s.pop()

        for party in people[t]:
            if not can_bluf[party]: continue
            can_bluf[party] = False
            s.extend(parties[party])

    return can_bluf.count(True)


print(solution())
