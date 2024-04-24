def solution(arr):
    lcm = 1
    for i in arr:
        lcm = get_lcm(lcm, i)

    return lcm


def get_lcm(a, b):
    mul = 1
    while True:
        has_d = False
        for i in range(2, min(a, b) + 1):
            if a % i == 0 and b % i == 0:
                has_d = True
                mul *= i
                a //= i
                b //= i
                break
        if not has_d:
            return mul * a * b
