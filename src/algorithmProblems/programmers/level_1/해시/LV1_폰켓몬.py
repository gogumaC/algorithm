# 9:40 ~ 9:53
def solution(nums):
    count = {}
    for n in nums:
        if n not in count: count[n] = 0
        count[n] += 1

    count = sorted(count.items(), key=lambda x: x[1])
    answer = 0
    if len(count) >= len(nums) // 2:
        answer = len(nums) // 2
    else:
        answer = len(count)

    return answer
