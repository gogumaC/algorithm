def solution(A):
    count={}

    for a in A:
        if a not in count:
            count[a]=0
        count[a]+=1
    
    result=[k for k,c in count.items() if c%2==1]
    return result[0]