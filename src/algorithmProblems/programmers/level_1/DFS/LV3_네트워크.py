from collections import deque
def solution(n, computers):
    answer = 0
    s=deque()
    visited=[False for _ in range(n)]
    for i in range(n):
        if visited[i]:
            continue
        answer+=1
        s.append(i)
        visited[i]=True
        while s:
            current=s.pop()
            for j in range(n):
                if computers[current][j]==0 or j==current or visited[j]:
                    continue
                s.append(j)
                visited[j]=True
    return answer