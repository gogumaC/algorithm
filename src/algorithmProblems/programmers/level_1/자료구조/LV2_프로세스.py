# 10:06~10:47
from collections import deque


def solution(priorities, location):
    q = deque([(v, i) for i, v in enumerate(priorities)])
    s = sorted([(-v, v) for _, v in enumerate(priorities)])

    idx = 0
    while True:
        cur = q.popleft()
        if s[idx][1] == cur[0]:
            idx += 1
            if cur[1] == location: return idx
        else:
            q.append(cur)
