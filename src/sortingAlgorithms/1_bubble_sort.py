def bubble_sort(arr):
    for i in range(len(arr)):
        for j in range(len(arr)-i-1):
            if arr[j]>arr[j+1]:
                arr[j],arr[j+1]=arr[j+1],arr[j]
    print(arr)

arr = [64, 34, 25, 12, 22, 11, 90]
bubble_sort(arr)