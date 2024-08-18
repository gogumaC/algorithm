import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().strip().split()))

arr = [[i, v, i - 1, i + 1, False] for i, v in enumerate(arr)]  # 초기,값,이전,다음
offsets = (1, -1)
d_count = 0
while True:
    for i, v, pi, ni, is_removed in arr:
        if is_removed:
            continue
        if ni in range(N):
            if v >= arr[ni][1]:
                arr[ni][4] = True
                arr[i][1] += arr[ni][1]
                arr[i][3] = arr[ni][3]
                nni = arr[ni][3]
                if nni in range(N):
                    arr[nni][2] = i
                d_count += 1
        if pi in range(N):
            if v >= arr[pi][1]:
                arr[pi][4] = True
                arr[i][1] += arr[pi][1]
                arr[i][2] = arr[pi][2]
                ppi = arr[pi][2]
                if ppi in range(N):
                    arr[ppi][3] = i
                d_count += 1

    if d_count == N - 1: break

res = [item for item in arr if item[4] == False][0]
print(res[1])
print(res[0] + 1)
