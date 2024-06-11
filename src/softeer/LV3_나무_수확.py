import sys #4:45 ~ 5:10
from collections import deque


input=sys.stdin.readline
n=0
offsets=((0,1),(1,0))
field=[]
answer=0

def main():
    global n,is_visited,field,answer
    n=int(input())
    field=[list(map(int,input().split())) for _ in range(n)]
    dp=[[[0 for _ in range(2) ] for j in range(n+1)] for i in range(n+1)]
    for i in range(1,n+1):
        for j in range(1,n+1):
            dp[i][j][0]=max(dp[i-1][j][0],dp[i][j-1][0])+field[i-1][j-1]
            double_prev=max(dp[i-1][j][1],dp[i][j-1][1])+field[i-1][j-1]
            double_me=dp[i][j][0]+field[i-1][j-1]
            dp[i][j][1]=max(double_prev,double_me)

    print(dp[-1][-1][1])
    
            
        
main()