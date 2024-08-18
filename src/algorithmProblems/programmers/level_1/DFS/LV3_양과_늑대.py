from collections import deque
res=1

def efficient_dfs(n,current,next,sheep,wolf,tree,info,visited):
    global res
    for nxt in next:
        n_next=[nn for nn in next if nn!=nxt]
        n_next.extend(tree[nxt])
        n_sheep=sheep
        n_wolf=wolf
        if info[nxt]==0:
            n_sheep+=1
        else:
            n_wolf+=1
        if n_sheep>n_wolf:
            res=max(res,n_sheep)
            efficient_dfs(n,nxt,n_next,n_sheep,n_wolf,tree,info,visited)

def dfs(n,current,sheep,wolf,tree,info,visited,catched):
    global res
    
    for nxt in tree[current]:
        if visited[nxt]:
            continue
        visited[nxt]=True
        
        n_sheep=sheep
        n_wolf=wolf
        if not catched[nxt]:
            catched[nxt]=True
            if info[nxt]==0:
                n_sheep+=1
            else:
                n_wolf+=1
            n_visited=[False for _ in range(n)]
            n_visited[nxt]=True
            if n_sheep>n_wolf:
                res=max(res,n_sheep)
                dfs(n,nxt,n_sheep,n_wolf,tree,info,n_visited,catched)
            catched[nxt]=False
        else:
            dfs(n,nxt,sheep,wolf,tree,info,visited,catched)
        
        
    
def solution(info, edges):
    
    n=len(info)
    tree=[[] for _ in range(n)]
    for (parent,child) in edges:
        tree[parent].append(child)
        tree[child].append(parent)
    visited=[True]+[False]*(n-1)
    catched=[True]+[False]*(n-1)
    dfs(n,0,1,0,tree,info,visited,catched)
                
    return res