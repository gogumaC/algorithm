
def solution(A, K):
    if K==0 or not A:
        return A
    start=len(A)-K%len(A)
    result=[]
    for i in range(len(A)):
        current=(start+i)%len(A)
        result.append(A[current])

    return result