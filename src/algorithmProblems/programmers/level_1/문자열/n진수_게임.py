def solution(n, t, m, p):
    s = ''

    for i in range(p + m * t):
        s += change(i, n)

    answer = ''
    for i in range(0, t):
        answer += s[i * m + (p - 1)]

    return answer


lan = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F']


def change(i, n):
    if i == 0: return '0'
    res = ''
    m = i
    while m != 0:
        res += lan[m % n]
        m //= n
    return res[::-1]
