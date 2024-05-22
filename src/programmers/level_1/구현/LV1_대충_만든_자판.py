def solution(keymap, targets):
    min_count = {}
    for m in keymap:
        for j in range(len(m)):
            c = m[j]
            if c not in min_count:
                min_count[c] = 101
            min_count[c] = min(min_count[c], j + 1)

    answer = [0 for _ in range(len(targets))]
    for i in range(len(targets)):
        t = targets[i]
        for c in t:
            if c not in min_count:
                answer[i] = -1
                break
            else:
                answer[i] += min_count[c]

    return answer
