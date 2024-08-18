import sys
input=sys.stdin.readline

MAX=sys.maxsize
def solution(n,times):
    dp=[[MAX for j in range(2)] for i in range(n)]
    dp[0][0]=times[0][0]
    dp[0][1]=times[0][1]
    
    for i in range(1,n):
        dp[i][0]=min(dp[i-1][0]+times[i][0],dp[i-1][1]+times[i-1][3]+times[i][0])
        dp[i][1]=min(dp[i-1][1]+times[i][1],dp[i-1][0]+times[i-1][2]+times[i][1])

    res=min(dp[n-1])
    print(res)

N=int(input())
times=[list(map(int,input().split())) for _ in range(N-1)]
an,bn=map(int,input().split())
times+=[[an,bn,0,0]]
solution(N,times)
