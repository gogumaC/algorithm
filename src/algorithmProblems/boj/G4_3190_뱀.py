def main():
    n = int(input())
    k = int(input())

    arr = [[0 for _ in range(n)] for _ in range(n)]

    for _ in range(k):
        a, b = map(int, input().split())
        arr[a - 1][b - 1] = 1

    l = int(input())

    move = {}
    for _ in range(l):
        x, c = input().split()
        move[int(x)] = c
    path = [[0, 0]]
    t = 0
    direction = ((0, 1), (1, 0), (0, -1), (-1, 0))
    cd = 0

    while True:
        if t in move:
            op = move[t]
            if op == 'L':
                cd = (cd - 1) % 4
            else:
                cd = (cd + 1) % 4

        tail = path[0]
        head = path[len(path) - 1]

        nx = head[0] + direction[cd][0]
        ny = head[1] + direction[cd][1]

        if not (0 <= nx < n and 0 <= ny < n) or arr[nx][ny] == 2:
            break

        if arr[nx][ny] != 1:
            arr[tail[0]][tail[1]] = 0
            path.remove(tail)

        arr[nx][ny] = 2
        path.append([nx, ny])

        t += 1

    print(t + 1)


main()
