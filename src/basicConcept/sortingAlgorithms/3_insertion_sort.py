def insertion_sort(arr):
    n=len(arr)
    for i in range(n):
        current=arr[i]
        j=i-1
        while j>=0 and arr[j]>current:
            arr[j+1]=arr[j]
            j-=1
        arr[j+1]=current
            
    print(arr)

arr = [12, 11, 13, 5, 6]
insertion_sort(arr)
