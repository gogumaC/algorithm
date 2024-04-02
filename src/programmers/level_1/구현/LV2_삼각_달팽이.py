def solution(n):
    answer = []
    off=((1,0),(0,1),(-1,-1))
    arr=[[0 for _ in range(0,i+1)] for i in range (0,n)]
    idx=1
    col=0
    row=-1
    op=0
    for i in range(n,0,-1):
        for _ in range(0,i):
            ox,oy=off[op]
            row+=ox
            col+=oy
            arr[row][col] =idx
            idx+=1
        op=(op+1)%3
    
    return sum(arr,[])