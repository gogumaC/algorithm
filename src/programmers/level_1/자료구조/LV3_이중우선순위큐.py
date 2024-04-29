from heapq import heappop, heappush, heapify


def solution(operations):
    order = 1
    answer = []
    q = []

    for ops in operations:
        op, n = ops.split(" ")

        if op == 'I':
            heappush(q, int(n))
        elif op == "D" and n == '1' and len(q) > 0:
            popMax(q)
        elif op == 'D' and n == '-1' and len(q) > 0:
            popMin(q)

    if len(q) == 1:
        n = heappop(q)
        return [n, n]
    elif len(q) > 1:
        return [popMax(q), popMin(q)]

    return [0, 0]


def popMin(q):
    return heappop(q)


def popMax(q):
    q2 = []
    while len(q) > 0:
        v = heappop(q)
        q2.append(v)

    res = q2.pop()

    q.extend(q2)
    heapify(q)
    return res
