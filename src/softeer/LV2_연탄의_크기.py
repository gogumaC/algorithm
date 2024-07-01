import sys

input=sys.stdin.readline
def solution(n,arr):
    max_c=0
    for i in range(2,101):
        c=0
        for j in arr:
            if j%i==0:
                c+=1
        if c>max_c:
            max_c=c
    print(max_c)
    
    
    
n=int(input())
arr=list(map(int,input().split()))
solution(n,arr)