# 9:40~10:17
def solution(begin, target, words):
    dfs(0, begin, target, set(), words)
    return 0 if res == MAXIMUM else res


MAXIMUM = 200
res = MAXIMUM


def dfs(depth, begin, target, visited, words):
    global res

    if begin == target:
        res = min(res, depth)
        return

    for w in words:
        if w in visited: continue
        diff_count = 0
        for i in range(len(w)):
            if w[i] != begin[i]: diff_count += 1
            if diff_count >= 2: break

        if diff_count == 1:
            visited.add(w)
            dfs(depth + 1, w, target, visited, words)
            visited.remove(w)
