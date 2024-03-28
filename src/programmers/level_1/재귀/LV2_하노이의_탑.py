
res=[]

def hanoi(num,start,end,via):
    if num==1 : 
        res.append([start,end])
        return
    hanoi(num-1,start,via,end)
    res.append([start,end])
    hanoi(num-1,via,end,start)
 

def solution(n):
    hanoi(n,1,3,2)
    return res


