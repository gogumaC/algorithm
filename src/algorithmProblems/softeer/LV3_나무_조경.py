import sys

input=sys.stdin.readline

offsets=((0,1),(1,0))
result=0

n=0
board=[]
tie_result=[]
tied=[]

def main():
    global n,board,tie_result,tied
    n=int(input())
    board=[list(map(int,input().split())) for _ in range(n)]
    tie_result=[[[0 for _ in range(4)] for _ in range(n)] for _ in range(n)]
    tied=[[False for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for d,(ox,oy) in enumerate(offsets):
                x=i+ox
                y=j+oy
                if x not in range(n) or y not in range(n):
                    continue
                tie_result[i][j][d]=board[i][j]+board[x][y]
    for i in range(0,n):
        for j in range(0,n):
            tied[i][j]=True
            dfs(n*i+j,0,0)
            tied[i][j]=False
    print(result)
    
def dfs(current,sum,depth):
    global result,tied
    x=current//n
    y=current%n
    if depth==4:
        return
    for d,(ox,oy) in enumerate(offsets):
        tx=x+ox
        ty=y+oy
        if tx not in range(n) or ty not in range(n) or tied[tx][ty]:
            continue
        
        tied[tx][ty]=True
        result=max(result,new_sum)
        for c in range(current+1,n*n):
            nx=c//n
            ny=c%n
            if tied[nx][ny]:
                continue
            tied[nx][ny]=True
            dfs(c,new_sum,depth+1)
            tied[nx][ny]=False
        tied[tx][ty]=False
        
main()