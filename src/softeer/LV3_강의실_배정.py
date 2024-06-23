import sys
from operator import itemgetter

input=sys.stdin.readline

def solution(n,lectures):
    lectures.sort()
    count=0
    ps=0
    pf=0
    for f,s in lectures:
        if s>=pf:
            pf=f
            ps=s
            count+=1
    print(count)

N=int(input())
lectures=[list(map(int,input().split()))[::-1] for _ in range(N)]
solution(N,lectures)