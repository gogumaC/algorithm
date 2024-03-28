from collections import deque

oil=[]

of=[[0,1],[1,0],[-1,0],[0,-1]]
dc={}

def dfs(mark,x,y,land):
    s=deque()
    s.append([x,y])
    oil[x][y]=mark
    count=1
    while len(s)>0:
        x,y=s.pop()
        
        for ox,oy in of:
            nx=x+ox
            ny=y+oy
            if nx in range(len(land)) and ny in range(len(land[0])) and land[nx][ny]==1 and oil[nx][ny]==0:
                oil[nx][ny]=mark
                count+=1
                s.append([nx,ny])
    dc[mark]=count
    
def solution(land):
    
    global oil
    oil=[[0]*len(land[0]) for _ in land]
    
    mark=1
    
    for i in range(len(land[0])):
        for j in range(len(land)):
            if oil[j][i]==0 and land[j][i]==1:
                dfs(mark,j,i,land)
                mark+=1
    
    maxv=0
    for i in range(len(land[0])): 
        s=set([ oil[j][i] for j in range(len(land)) if land[j][i]==1 ])
        sumv=sum([dc[m] for m in s])
        maxv=max(maxv,sumv)   
                        
    answer = maxv
    return answer
