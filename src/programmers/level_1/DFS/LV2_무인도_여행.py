from collections import deque
def solution(maps):
    answer = []
    is_visited=[[False for _ in maps[0]] for _ in maps]
    
    for i,_ in enumerate(maps):
        for j,_ in enumerate(maps[0]):
            if(not is_visited[i][j] and maps[i][j]!='X'):
                answer.append(dfs(i,j,maps,is_visited))
    
    #print(is_visited)
    answer.sort()
    return [-1] if len(answer)==0 else answer

off=((0,1),(0,-1),(1,0),(-1,0))

def dfs(x,y,maps,is_visited):
    s=deque()
    c=int(maps[x][y])
    s.append((x,y))
    is_visited[x][y]=True
    
    while len(s)>0:
        cx,cy=s.pop()
        for ox,oy in off:
            nx=cx+ox
            ny=cy+oy
            if 0<=nx<len(maps) and 0<=ny<len(maps[0]) and not is_visited[nx][ny] and maps[nx][ny]!='X':
                is_visited[nx][ny]=True
                c+=int(maps[nx][ny])
                s.append((nx,ny))
    return c
        
        