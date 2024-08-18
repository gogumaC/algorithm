import heapq
import sys

def dijkstra(n,graph,start):
    pq=[(0,start)]
    heapq.heapify(pq)
    min_l=[sys.maxsize for _ in range(n+1)]
    min_l[start]=0
    visited=[False for _ in range(n+1)]
    
    while pq:
        (_,current)=heapq.heappop(pq)
        if visited[current]:
            continue
        visited[current]=True
        for nx,nc in graph[current]:
            if visited[nx]:
                continue
            min_l[nx]=min(min_l[nx],min_l[current]+nc)
            heapq.heappush(pq,(min_l[nx],nx))
        #print(pq)
    return min_l

def solution_with_dijkstra(n, s, a, b, fares):
    
    graph={}
    for st,fin,c in fares:
        if st not in graph:
            graph[st]=[]
        if fin not in graph:
            graph[fin]=[]
        graph[st].append((fin,c))
        graph[fin].append((st,c))
        
    start_to=dijkstra(n,graph,s)
    a_to=dijkstra(n,graph,a)
    b_to=dijkstra(n,graph,b)
    
        
    ans=sys.maxsize
    for i in range(1,n+1):
        total=start_to[i]+a_to[i]+b_to[i]
        ans=min(ans,total)
    
    return ans

def solution_with_floyd(n, s, a, b, fares):
    import sys
    min_l=[[sys.maxsize if i!=j else 0 for j in range(n+1)] for i in range(n+1)]
    for st,fin,c in fares:
        min_l[st][fin]=c
        min_l[fin][st]=c
        
    for via in range(1,n+1):
        for start in range(1,n+1):
            for finish in range(1,n+1):
                if start==via or finish==via or start==finish:
                    continue
                min_l[start][finish]=min(min_l[start][finish],min_l[start][via]+min_l[via][finish])
                min_l[finish][start]=min_l[start][finish]
    ans=min_l[s][a]+min_l[s][b]
    for i in range(1,n+1):
        together=min_l[s][i]
        to_a=min_l[i][a]
        to_b=min_l[i][b]
        total=together+to_a+to_b
        ans=min(ans,total)
    return ans
