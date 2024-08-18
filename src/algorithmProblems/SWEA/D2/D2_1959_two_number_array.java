package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1959_two_number_array {

    /*
    * 풀이 개요
    * 1. 두 배열의 크기를 비교
    * 2. 크기가 작은 배열과 큰 배열의 차를 구해서 0부터 차까지 케이스마다 결과를 구함
    * 3. 최댓값을 찾음
    * */
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();



        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            sc.nextLine();
            int[] a= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] b= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int ans=(n>m)?getMaxMult(a,b):getMaxMult(b,a);
            System.out.println("#"+test_case+" "+ans);
        }
    }

    static int getMaxMult(int[] longArr, int[] shortArr){
        int max=0;
        for(int i=0;i<=longArr.length-shortArr.length;i++){
            int mul=0;
            for(int j=0;j<shortArr.length;j++){
                mul+=shortArr[j]*longArr[j+i];
            }
            max=Math.max(max,mul);
        }
        return max;
    }
}
