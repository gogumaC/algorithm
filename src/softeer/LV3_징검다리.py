import sys

input=sys.stdin.readline

def solution_with_dp(n,heights): #DP사용
    dp=[1 for _ in range(n)]
    result=1
    for i in range(n):
        c=heights[i]
        for j in range(i+1,n):
            c2=heights[j]
            if c2>c:
                dp[j]=max(dp[j],dp[i]+1)
                result=max(result,dp[j])

    print(result)

import sys

input=sys.stdin.readline

def binary_search(arr,h):
    s=0
    e=len(arr)-1
    while s<=e:
        mid=s+(e-s)//2
        if arr[mid]<h:
            s=mid+1
        elif arr[mid]>h:
            e=mid-1
        elif arr[mid]==h:
            return mid
    return s

def solution_with_binary_search(n,heights):
    result=1
    arr=[]
    for h in heights:
        if not arr:
            arr.append(h)
        else:
            index=binary_search(arr,h)
            if index==len(arr):
                arr.append(h)
                result=len(arr)
            elif arr[index]>h:
                arr[index]=h
    print(result)

N=int(input())
heights=list(map(int,input().split()))
solution_with_binary_search(N,heights)