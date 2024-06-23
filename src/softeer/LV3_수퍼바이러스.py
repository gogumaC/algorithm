import sys

input=sys.stdin.readline

div=1000000007
mem={}
def div_conq(e):
    result=0
    if e in mem:
        result= mem[e]
    elif e%2==0:
        temp=div_conq(e//2)%div
        result=temp*temp
    else:
        temp=div_conq((e-1)//2)%div
        result=temp*temp*div_conq(1)
    mem[e]=result
    return result
    
def solution(k,p,n):
    mem[1]=p
    inc_count=n*10
    print((k*div_conq(inc_count))%div)
    
K,P,N=map(int,input().split())
solution(K,P,N)