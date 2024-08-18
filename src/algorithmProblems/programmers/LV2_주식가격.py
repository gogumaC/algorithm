import heapq
def solution(prices):
    hq=[]
    answer = [0 for _ in prices]
    heapq.heapify(hq)
    for t,p in enumerate(prices):
        while len(hq)>0 and hq[0][1]>p:
            _,_,lt=heapq.heappop(hq)
            answer[lt]=(t-lt)
        heapq.heappush(hq,(-p,p,t))
    
    while hq:
        _,_,lt=heapq.heappop(hq)
        answer[lt]=len(prices)-lt-1
    
    return answer

def efficiency_solution(prices):
    answer = [0]*len(prices)
    st=[]
    
    for t,p in enumerate(prices):
        while len(st)>0 and st[-1][0]>p:
            (_,lt)=st.pop()
            answer[lt]=t-lt
        st.append((p,t))
        
    while len(st)>0:
        (_,lt)=st.pop()
        answer[lt]=len(prices)-lt-1
    return answer