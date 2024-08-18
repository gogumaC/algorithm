package SWEA.D3;

import java.util.Scanner;

public class D3_16910_point_in_circle {

    /*
    * 풀이개요
    * : x축을 0~N까지 1씩 증가시키면서 해당 x에서 y축에 있는 격자수를 구함
    * : y=sqrt(N^2-x^2) 사용해서 해당 x축에 가장 높은 y 좌표를 구함
    * : 위에서 sqrt는 실수형을 반환하므로 반드시 (int)로 캐스팅해서 소수점 아래를 버려야함!
    *
    * */
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n=sc.nextInt();
            int count=0;
            for(int x=0;x<=n;x++){
                count+=2*(int)Math.sqrt(n*n-x*x)+1;
            }
            count=2*count-(2*n+1);
            System.out.println("#"+test_case+" "+count);
        }
    }
}
