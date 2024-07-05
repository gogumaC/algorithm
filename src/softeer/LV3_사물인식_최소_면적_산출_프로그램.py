import sys

input=sys.stdin.readline
res=sys.maxsize

def solution(N,K,points):
    color_p=[[] for _ in range(K)]
    for i in range(N):
        x,y,k=points[i]
        color_p[k-1].append((x,y))
   
    for (x,y) in color_p[0]:
        bt(N,K,x,x,y,y,0,1,color_p)
    print(res)


def bt(N,K,x1,x2,y1,y2,area,depth,points):
    global res
    if depth==K:
        res=min(res,area)
        return
    
    for p in points[depth]:
        px,py=p
        nx1=min(x1,px)
        nx2=max(x2,px)
        ny1=min(y1,py)
        ny2=max(y2,py)
        n_area=abs((nx2-nx1)*(ny2-ny1))
        if n_area<res:
            bt(N,K,nx1,nx2,ny1,ny2,n_area,depth+1,points)


N,K=map(int,input().split())
points=[list(map(int,input().split())) for _ in range(N)]

solution(N,K,points)
#test=[(0,0,i%20+1) for i in range(100)]
#solution(100,20,test)