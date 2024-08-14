import sys
from collections import deque

team=[]
new_s=[]
dp=[]

sys.setrecursionlimit(300100)

def dfs(current,is_join):
    
    if dp[current][is_join]!=None:
        return dp[current][is_join]
    
    if current not in team:
        dp[current][0]=0
        dp[current][1]=new_s[current]
        return dp[current][is_join]
    
    sums=0
    #나 포함 가는경우
    for f in team[current]:
        sums+=min(dfs(f,0),dfs(f,1))
    dp[current][1]=sums+new_s[current]
    
    # 나빼고 가는경우
    min_res=sys.maxsize
    for f in team[current]:
        res=sums-min(dfs(f,0),dfs(f,1))+dfs(f,1)
        min_res=min(min_res,res)
    dp[current][0]=min_res
    
    return dp[current][is_join]
            
        
def solution(sales, links):
    global team,new_s,dp
    team={}
    new_s=[0]+sales[:]
    dp=[[None,None] for i in range(len(new_s))]
    for (a,b) in links:
        if a not in team:
            team[a]=[]
        team[a].append(b)
        
    a=dfs(1,1)
    b=dfs(1,0)
    
    answer = min(a,b)
    return answer

# test_s=[i for i in range(1,300001)]
# test_l=[[i,i+1] for i in range(1,300000)]

# solution(test_s,test_l)