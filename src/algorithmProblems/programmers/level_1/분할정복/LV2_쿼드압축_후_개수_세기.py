
def solution(arr):
    answer=list(d(0,0,len(arr),arr))
    return answer

def d(sx,sy,unit,arr):
    if unit==1 : return (0,1) if arr[sx][sy]==1 else (1,0)
    
    tl=d(sx,sy,unit//2,arr)
    tr=d(sx,sy+unit//2,unit//2,arr)
    bl=d(sx+unit//2,sy,unit//2,arr)
    br=d(sx+unit//2,sy+unit//2,unit//2,arr)
    
    res= tuple(sum(elem) for elem in zip(tl,tr,bl,br))
    z,o=res
    if z==0 : return (0,1)
    if o==0 : return (1,0)
    
    return res
        
        