import sys
from collections import deque

input=sys.stdin.readline
max_score=0

def solution(n,field):
    field.reverse()
    board=list(zip(*field))
    bt(board,0,0,n)
    print(max_score)

def bt(board,score,depth,N):
    global max_score
    if depth==3:
        max_score=max(max_score,score)
        return
    visited=[[False for _ in range(N)] for _ in range(N)]
    hn=has_n(board,N)
    for i in range(N):
        for j in range(N):
            if visited[i][j]:
                continue
            if not hn[i][j]:
                visited[i][j]=True
                n_board=[[b for b in br] for br in board]
                n_board[i].pop(j)
                bt(n_board,score+2,depth+1,N)
                continue
            
            n_score,n_board,rm=dfs(i,j,board,visited,N)
            if depth<2: 
                remove(n_board,rm)
            if max_score-(score+n_score)>(N-depth)*2*N*N:
                return
            bt(n_board,score+n_score,depth+1,N)

dir=((0,-1),(0,1),(1,0),(-1,0))

def dfs(sx,sy,board,visited,N):
    n_board=[[b for b in br] for br in board]
    s=deque([(sx,sy)])
    tc=board[sx][sy]
    visited[sx][sy]=True
    remove=[(sx,sy)]
    count=1
    x1=x2=sx
    y1=y2=sy

    while s :
        cx,cy=s.popleft()
        for dx,dy in dir:
            nx=cx+dx
            ny=cy+dy
            if nx not in range(N) or ny not in range(N) or visited[nx][ny] or board[nx][ny]!=tc:
                continue
            visited[nx][ny]=True
            s.append((nx,ny))
            remove.append((nx,ny))
            x1=min(nx,x1)
            x2=max(nx,x2)
            y1=min(ny,y1)
            y2=max(ny,y2)
            count+=1
    score=count+((x2-x1+1)*(y2-y1+1))
    remove.sort(reverse=True)
    return (score,n_board,remove)

def bfs(sx,sy,board,visited,N):
    n_board=[[b for b in br] for br in board]
    q=deque([(sx,sy)])
    tc=board[sx][sy]
    visited[sx][sy]=True
    remove=[(sx,sy)]
    count=1
    x1=x2=sx
    y1=y2=sy

    while q :
        cx,cy=q.popleft()
        for dx,dy in dir:
            nx=cx+dx
            ny=cy+dy
            if nx not in range(N) or ny not in range(N) or visited[nx][ny] or board[nx][ny]!=tc:
                continue
            visited[nx][ny]=True
            q.append((nx,ny))
            remove.append((nx,ny))
            x1=min(nx,x1)
            x2=max(nx,x2)
            y1=min(ny,y1)
            y2=max(ny,y2)
            count+=1
    score=count+((x2-x1+1)*(y2-y1+1))
    remove.sort(reverse=True)
    return (score,n_board,remove)

def remove(n_board,remove):
    #print(remove)
    for rx,ry in remove:
        n_board[rx].pop(ry)
        
def has_n(board,N):
    hn=[[False for j in range(N)] for i in range(N)]
    for i in range(N-1):
        for j in range(N):  
            if board[i][j]==board[i+1][j]:
                hn[i][j]=hn[i+1][j]=True
    for i in range(N):
        for j in range(N-1):  
            if board[i][j]==board[i][j+1]:
                hn[i][j]=hn[i][j+1]=True
    return hn
    

def print_board(board):
    for b in board:
        print(b)
        
N=int(input())
field=[list(map(int,input().split())) for _ in range(3*N)]

solution(N,field)
#solution(15,[[2if (i+j)%2==0 else 1 for j in range(15)] for i in range(3*15)])
#solution(15,[[1 for j in range(15)] for i in range(3*15)])