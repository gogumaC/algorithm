import sys
from collections import deque

input=sys.stdin.readline

def solution(n,m,field):
    time=0

    while True:
        remove_count=bfs(n,m,field)#dfs(n,m,field)
        if remove_count==0:
            print(time)
            break
        time+=1


def bfs(n,m,field):
    visited=[[0 for _ in range(m+2)] for _ in range(n+2)]
    dirs=((-1,0),(1,0),(0,-1),(0,1))
    q=deque()
    q.append((0,0))
    visited[0][0]=-1
    remove=[]
    while q:
        cx,cy=q.popleft()
        for (dx,dy) in dirs:
            nx=cx+dx
            ny=cy+dy
            if nx not in range(n+2) or ny not in range(m+2) or visited[nx][ny]==-1: 
                continue
            if field[nx][ny]>0:
                visited[nx][ny]+=1
                if visited[nx][ny]==2:
                    remove.append((nx,ny))
            elif field[nx][ny]==0:
                visited[nx][ny]=-1
                q.append((nx,ny))
                
    for (rx,ry) in remove:
        field[rx][ry]=0
    return len(remove)
        
        
def dfs(n,m,field):
    dirs=((-1,0),(1,0),(0,-1),(0,1))
    is_visited=[[0 for _ in range(m+2)] for _ in range(n+2)]
    s=deque()
    is_visited[0][0]=True
    s.append((0,0))
    remove=[]
    while s:
        cx,cy=s.pop()
        for (dx,dy) in dirs:
            nx=cx+dx
            ny=cy+dy
            if nx not in range(n+2) or ny not in range(m+2) or is_visited[nx][ny]==-1: 
                continue
            if field[nx][ny]>0:
                is_visited[nx][ny]+=1
                if is_visited[nx][ny]==2:
                    remove.append((nx,ny))
            elif field[nx][ny]==0:
                is_visited[nx][ny]=-1
                s.append((nx,ny))
    for (rx,ry) in remove:
        field[rx][ry]=0
    return len(remove)
            
N,M=map(int,input().split())
field=[[0]+list(map(int,input().split()))+[0] for _ in range(N)]
field=[[0]*(M+2)]+field+[[0]*(M+2)]
solution(N,M,field)

#solution(100,100,[[1 if i!=0 and j!=0 else 0 for j in range(102)] for i in range(102)])