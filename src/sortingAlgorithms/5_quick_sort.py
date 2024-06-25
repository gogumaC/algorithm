def quick_sort(low,high,arr):
    if high-low+1==1:
        return
    mid=low+(high-low)//2
    pivot=arr[mid]
    left=low
    right=high

    while left!=right:
        while arr[right]>pivot:
            right-=1
        
        while arr[left]<pivot:
            left+=1
        if arr[left]>arr[right]:
            arr[right],arr[left]=arr[left],arr[right]

    if right-1>low: quick_sort(low,right-1,arr)
    if right+1<high: quick_sort(right+1,high,arr)


arr = [10, 7, 8, 9, 1, 5]
quick_sort(0,len(arr)-1,arr)
print(arr)


