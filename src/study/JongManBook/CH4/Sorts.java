package JongManBook.CH4;

import java.util.ArrayList;

public class Sorts {

    //선택정렬
    void selectionSort(int[] arr){
        int N=arr.length;
        for(int i=0;i<N;i++){
            int minIndex=i;
            //해당 i~n-1의 가장작은 원소를 찾아 arr[i]에 넣음
            for(int j=i+1;j<N;j++){
                if(minIndex>arr[j]){
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }

    void insertionSort(int[] arr){
        int N=arr.length;
        for(int i=0;i<N;i++){

            int j=i;
            //선택된 인덱스의 값보다 작은 값이 나올때까지 앞으로 옮김
            while(j>0 && arr[j]<arr[j-1]){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                    break;
                }
                j--;
            }
        }
    }
}
