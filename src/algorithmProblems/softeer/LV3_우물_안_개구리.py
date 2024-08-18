import sys
from collections import deque

input=sys.stdin.readline

def solution(n,m,w,r): # not efficient : O(n*m)
    is_lose=[False for _ in range(n+1)]
    l_count=0
    for i in range(1,n+1):
        if is_lose[i] or i not in r: continue
        for j in r[i]:
            if w[j]>=w[i]:
                is_lose[i]=True
                l_count+=1
                break
    print(n-l_count)

def efficient_solution(n,m,w,r): # more efficient : O(NlogN+N+M)
    sw=[(v,i) for i,v in enumerate(w)]
    sw.sort(reverse=True)
    loses=set()
    for v,i in sw:
        if i in loses or i not in r:continue

        s=deque()
        while s:
            cw,ci=s.pop()
            if ci not in r: continue
            for j in r[ci]:
                if j in loses: continue
                if w[ci]==w[j]:
                    loses.add(ci)
                if w[ci]>=w[j]:
                    loses.add(j)
                    s.append(j)
                
        for j in r[i]:  
            if w[j]>=w[i]:
                loses.add(i)
            if w[j]<=w[i]:
                loses.add(j)
    print(n-len(loses))
            
                          

N,M=map(int,input().split())
W=[0]+list(map(int,input().split()))
r={}
for i in range(M):
    a,b=map(int,input().split())
    if a not in r:
        r[a]=[]
    if b not in r:
        r[b]=[]
    r[a].append(b)
    r[b].append(a)

efficient_solution(N,M,W,r)
#efficient_solution(100000,100000,[1000000000]*100001,[[1000000000 for _ in range(100001)] for _ in range(100001)])
#efficient_solution(2,1,[1]*3,{})