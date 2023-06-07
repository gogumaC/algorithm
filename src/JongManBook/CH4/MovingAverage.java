package JongManBook.CH4;

import java.util.ArrayList;

//p.94 ~ p.97
// 이동평균 구하기
public class MovingAverage {

    public static void main(String[] args){

    }

    // O(N^2) : 그냥 구하기
    static ArrayList<Double> getMovingAverage(int[] arr,int M){
        ArrayList<Double> movingAvgs=new ArrayList<Double>();

        for(int i=M-1;i<arr.length;i++){
            int sum=0;
            for(int j=0;j<M;j++){
                sum+=arr[i-j];
            }
            movingAvgs.add((double)sum/M);
        }

        return movingAvgs;

    }

    // O(N) : 선형 시간에 구하기 (중복계산 제거)
    static ArrayList<Double> getMovingAverage2(int[] arr,int M){

        ArrayList<Double> movingAvgs= new ArrayList<Double>();
        int sum=0;
        for(int i=0;i<M-1;i++){
            sum+=arr[i];
        }

        for(int i=M-1;i<arr.length;i++){
            sum+=arr[i];
            movingAvgs.add((double)sum/M);
            sum-=arr[i-M+1];
        }

        return movingAvgs;
    }


}
