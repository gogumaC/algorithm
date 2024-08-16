from collections import deque

def solution(bridge_length, weight, truck_weights):
    time=0
    q=deque()
    current_w=0
    for w in truck_weights:
        time+=1
        while q and (w+current_w>weight or time-q[0][1]==bridge_length):
            out=q.popleft()
            current_w-=out[0]
            time=out[1]+bridge_length      
        q.append((w,time))
        current_w+=w
    
    time+=bridge_length

    return time

def test():
    #min
    print(solution(1,1,[1]))

    #max
    print(solution(10000,10000,[10000]*10000))
    
    #fit
    print(solution(10,10,[1]*10))
    
# test()