from collections import deque
import sys

input=sys.stdin.readline

def solution(N,K,line): #O(N*K)
    visited=[False for _ in range(N)]
    count=0
    for i in range(N):
        if line[i]=="P":
            for j in range(i-K,i+K+1):
                if j not in range(N) or j==i:
                    continue
                if line[j]=="H" and not visited[j]:
                    count+=1
                    visited[j]=True
                    break
                    
    print(count)

def efficient_solution(N,K,line): #O(N)
    q=deque()
    count=0
    for i in range(N):
        if line[i]=="H":
            q.append(i)
    for i in range(N):
        
        if line[i]=="P":
            
            while q and q[0]<i-K:
                q.popleft()
            if q and q[0]<=i+K:
                t=q.popleft()
                count+=1
            
    print(count)

      

N,K=map(int,input().split())
line=input()
#solution(N,K,line)
efficient_solution(N,K,line)
#solution(20000,10,"P"*19999+"H")