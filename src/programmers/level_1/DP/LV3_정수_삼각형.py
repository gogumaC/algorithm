def solution(triangle):

    dp=[l[:] for l in triangle]
    
    for i in range(len(dp)-1):
        for j in range(len(dp[i])):
            dp[i+1][j]=max(dp[i+1][j],dp[i][j]+triangle[i+1][j])
            dp[i+1][j+1]=max(dp[i+1][j+1],dp[i][j]+triangle[i+1][j+1])
    
    answer=max(dp[len(dp)-1])

    return answer