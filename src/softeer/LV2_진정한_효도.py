import sys

input=sys.stdin.readline
def sol(field):
    res=20
    gap=[[[abs(field[i][j]-(k+1)) for j in range(3)] for i in range(3)] for k in range(3)]
    for k in range(3):
        for i in range(3):
            res=min(res,sum(gap[k][i]))
            v_sum=0
            for j in range(3):
                v_sum+=gap[k][j][i]
            res=min(res,v_sum)
    print(res)

field=[list(map(int,input().split())) for _ in range(3)]

sol(field)