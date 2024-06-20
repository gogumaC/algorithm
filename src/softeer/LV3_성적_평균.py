import sys

input=sys.stdin.readline

def solution(n,k,scores,ranges):
    s_scores=[0]+scores
    sums=[0 for _ in range(n+1)]
    sums[1]=s_scores[1]
    for i in range(n+1):
        sums[i]=sums[i-1]+s_scores[i]   
    for s,e in ranges:
        sum=sums[e]-sums[s-1]
        avg=sum/(e-s+1)
        print(f"{avg:.2f}")

N,K=map(int,input().split())

scores=list(map(int,input().split()))

ranges=[list(map(int,input().split()))for _ in range(K)]

solution(N,K,scores,ranges)