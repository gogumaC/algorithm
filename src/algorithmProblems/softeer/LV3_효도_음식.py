import sys

input=sys.stdin.readline

def solution(n,arr):
    left_max=[0 for _ in range(n)]
    right_max=[0 for _ in range(n)]
        
    current_sum=arr[0]
    left_max[0]=arr[0]
    right_max[n-1]=arr[n-1]
    
    for i in range(1,n):
        current_sum=max(arr[i],current_sum+arr[i])
        left_max[i] = max(left_max[i-1],current_sum)
        
    current_sum=arr[-1]
    for i in range(n-2,-1,-1):
        current_sum=max(arr[i],current_sum+arr[i])
        right_max[i]=max(right_max[i+1],current_sum)

    max_sum=-sys.maxsize
    for i in range(1,n-1):
        current=left_max[i-1]+right_max[i+1]
        max_sum=max(max_sum,current)

    print(max_sum)


n=int(input())
arr=list(map(int,input().split())) 
solution(n,arr)