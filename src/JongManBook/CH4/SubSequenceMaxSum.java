package JongManBook.CH4;

public class SubSequenceMaxSum {

    //무식하게 풀어보기 : O(N^3)
    int inefficientMaxSum(int[] arr){
        int N=arr.length;
        int max=0;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                //부분수열의 합 계산
                int sum=0;
                for(int k=i;k<j;k++){
                    sum+=arr[k];
                }
                max=Math.max(max,sum);
            }
        }
        return max;
    }

    //중복계산 줄이기 : O(N^2)
    int betterMaxSum(int[] arr){
        int N=arr.length;
        int max=0;
        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=i;j<N;j++){
                //기존에 계산했던 arr[0]~arr[j-1]에 arr[j]값만 더해서 활용
                sum+=arr[j];
                max=Math.max(max,sum);
            }
        }

       return max;
    }

    //분할 정복으로 풀기 : O(NlogN)
    int fastMaxSum(int[] arr, int lo,int hi){

        //구간의 길이가 1인경우
        if(lo==hi) return arr[lo];

        //1. 배열을 두조각으로 나눔 : arr[i~mid] , arr[mid+1,i]
        int mid=(lo+hi)/2; //중간 인덱스

        //2. 두 부분에 걸치는 최대구간 찾기 : 이 구간은 앞구간 일부+뒷구간 일부로 이루어짐
        int left=Integer.MIN_VALUE; // 앞구간의 최댓값
        int right=Integer.MIN_VALUE; //뒷구간의 최댓값
        int sum=0;

        //앞, 뒤부분 의 최대구간을 합치면 두 부분에 걸치는 가장 큰 최대구간을 찾을 수 있따.

        //앞구간의 최대 합 찾기
        for(int i=mid;i>lo;i--){
            sum+=arr[i];
            left=Math.max(left,sum);
        }

        //뒷 구간의 최대 합 찾기
        sum=0;
        for(int i=mid+1;i<hi;i++){
            sum+=arr[i];
            right=Math.max(right,sum);
        }

        //3. 최대구간이 두 구간중 한 구간에만 속해있는 경우의 답을 재귀호출로 찾는다.
        int single=Math.max(fastMaxSum(arr,lo,mid),fastMaxSum(arr,mid+1,hi));

        //4. 두 경우 중 최대치를 반환한다.
        return Math.max(left+right,single);

    }

    //동적계획법으로 풀기 : O(N)
    int fasterMaxSum(int[] arr){
        //maxAt(i)=max(0,maxAt(i-1))+A[i]

        int N=arr.length;
        int psum=0;
        int max=0;
        for(int i=0;i<N;i++){
            psum=Math.max(0,psum)+arr[i];
            max=Math.max(psum,max);
        }

        return max;
    }


}
