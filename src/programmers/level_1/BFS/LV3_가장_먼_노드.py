from collections import deque

def bfs(graph,start,n):
    q=deque()
    q.append((start,0))
    visited=[0 for _ in range(n+1)]
    visited[start]=True
    length=[0 for _ in range(n+1)]
    
    while q:
        current,depth=q.popleft()
        for n in graph[current]:
            if visited[n]:
                continue
            length[n]=depth+1
            visited[n]=True
            q.append((n,depth+1))
    
    length.sort(reverse=True)
    
    max_l=length[0]
    count=0
    for l in length:
        if l==max_l:
            count+=1
        else:
            break
    return count
            

def solution(n, edge):
    
    graph={}
    for (u,v) in edge:
        if u not in graph:
            graph[u]=[]
        if v not in graph:
            graph[v]=[]
        graph[u].append(v)
        graph[v].append(u)
    
    answer = bfs(graph,1,n)
    return answer