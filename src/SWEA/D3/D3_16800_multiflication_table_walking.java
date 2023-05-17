package SWEA.D3;

import java.util.Scanner;

public class D3_16800_multiflication_table_walking {

    /*
    * 풀이 개요
    * :처음에는 i=1~N까지 반복하며 i가 N의 factor인 경우 좌표를 모두 찾아서 x,y를 더한 값중 최소값을 찾는 방식으로 접근
    * -> 입력이 int범위를 벗어나 long이므로 반복횟수가 너무많아 시간초과로 실패함
    * : 시간을 줄이기 위해 다이나믹 프로그래밍도 생각해봤지만 적합하지 않아보였음
    * : 생각해보니 가장 짧은 거리는 x=y일때 이므로 N의 제곱근을 이용해 가장 짧을 가능성이 있는 제곱근 부근부터 1까지 순차적으로 조사하는 방법으로 전환
    * : 1~N반복에서 1~sqrt(N)까지로 반복횟수가 줄어 시간 줄임
    * */
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            long n=sc.nextLong();
            long min = 0;
            for (int i = (int) Math.sqrt(n); i > 0; i--) {
                if (n % i == 0) {
                    min = n / i + i - 2;
                    break;
                }
            }
            System.out.println("#" + test_case + " " + min);

        }
    }
}
